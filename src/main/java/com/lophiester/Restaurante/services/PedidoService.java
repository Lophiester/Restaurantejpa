package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.ItemPedido;
import com.lophiester.Restaurante.domain.PagamentoComBoleto;
import com.lophiester.Restaurante.domain.Pedido;
import com.lophiester.Restaurante.domain.enums.EstadoPagamento;
import com.lophiester.Restaurante.repositories.ItemPedidoRepository;
import com.lophiester.Restaurante.repositories.PagamentoRepository;
import com.lophiester.Restaurante.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private BoletoService boletoService;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EmailService emailService;

    public Pedido findById(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(null);
    }

    @Transactional
    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setCliente(clienteService.findById(obj.getCliente().getId()));
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = pedidoRepository.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setProduto(produtoService.findById(obj.getCliente().getId()));
            ip.setDesconto(0L);
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);

        }
        itemPedidoRepository.saveAll(obj.getItens()
        );
        emailService.sendOrderConfirmationHtmlEmail(obj);
        return obj;
    }
}
