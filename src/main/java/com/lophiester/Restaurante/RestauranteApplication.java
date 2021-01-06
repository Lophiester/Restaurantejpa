package com.lophiester.Restaurante;

import com.lophiester.Restaurante.domain.*;
import com.lophiester.Restaurante.domain.Enums.EstadoPagamento;
import com.lophiester.Restaurante.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner {


    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestauranteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Pratos");
        Categoria cat2 = new Categoria(null, "Bebidas");
        Categoria cat3 = new Categoria(null, "Lanches");
        Categoria cat4 = new Categoria(null, "Sobremesas");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));

        Produto p1 = new Produto(null, "arroz com feijao", 2000L);
        Produto p2 = new Produto(null, "macarrao", 1000L);
        Produto p3 = new Produto(null, "lazanha", 950L);
        Produto p4 = new Produto(null, "guarana", 250L);
        Produto p5 = new Produto(null, "brigadeiro", 400L);
        Produto p6 = new Produto(null, "pastel", 500L);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p4));
        cat3.getProdutos().addAll(Arrays.asList(p6));
        cat4.getProdutos().addAll(Arrays.asList(p5));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1));
        p3.getCategorias().addAll(Arrays.asList(cat1));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat4));
        p6.getCategorias().addAll(Arrays.asList(cat3));

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

        Provincia pro1 = new Provincia(null, "愛知県");
        Provincia pro2 = new Provincia(null, "大阪府");

        provinciaRepository.saveAll(Arrays.asList(pro1, pro2));

        Cidade cid1 = new Cidade(null, "西尾市", pro1);
        Cidade cid2 = new Cidade(null, "日進市", pro1);
        Cidade cid3 = new Cidade(null, "大阪市", pro2);

        pro1.getCidades().addAll(Arrays.asList(cid1, cid2));
        pro2.getCidades().addAll(Arrays.asList(cid3));

        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        Cliente cli1 = new Cliente(null, "Carlos Morales", "carlos@gmail.com");
        cli1.getTelefones().addAll(Arrays.asList("08099955"));

        Cliente cli2 = new Cliente(null, "Joao Morales", "joao@gmail.com");
        cli2.getTelefones().addAll(Arrays.asList("05552154"));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));

        Endereco end1 = new Endereco(null, "下町宮東18－２", "ビレッジハウス4-102", "0804508", cid1, cli1);
        Endereco end2 = new Endereco(null, "上田まち32-25", null, "080-1251", cid1, cli1);
        Endereco end3 = new Endereco(null, "大阪町12-2", "す大阪大学", "415-0802", cid3, cli2);

        cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
        cli2.getEnderecos().addAll(Arrays.asList(end3));

        enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
        Pedido ped1 = new Pedido(null,sdf.parse("01/01/2021 10:20"),cli1,end1);
        Pedido ped2 = new Pedido(null,sdf.parse("02/01/2021 11:20"),cli2,end3);
        Pedido ped3 = new Pedido(null,sdf.parse("03/01/2021 12:20"),cli1,end2);

        Pagamento pgto1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,ped1,sdf.parse("05/01/2021 00:00"),null);
        ped1.setPagamento(pgto1);
        Pagamento pgto2 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped2,6);
        ped2.setPagamento(pgto2);
        Pagamento pgto3 = new PagamentoEmDinheiro(null,EstadoPagamento.QUITADO,ped3,2000L);
        ped3.setPagamento(pgto3);

        cli1.getPedidos().addAll(Arrays.asList(ped1,ped3));
        cli2.getPedidos().addAll(Arrays.asList(ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3));
        pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2,pgto3));

        ItemPedido ip1 = new ItemPedido(ped1,p1,0L,1,2000L);
        ItemPedido ip2 = new ItemPedido(ped2,p2,0L,2,950L);
        ItemPedido ip3 = new ItemPedido(ped3,p3,100L,1,2000L);

        ped1.getItens().addAll(Arrays.asList(ip1));
        ped2.getItens().addAll(Arrays.asList(ip2));
        ped3.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1,ip2));
        p2.getItens().addAll(Arrays.asList(ip2));
        p3.getItens().addAll(Arrays.asList(ip3));

        itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

    }
}
