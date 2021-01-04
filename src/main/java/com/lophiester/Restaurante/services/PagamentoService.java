package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Pagamento;
import com.lophiester.Restaurante.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento buscar(Integer id) {
        Optional<Pagamento> obj = pagamentoRepository.findById(id);
        return obj.orElseThrow(null);
    }
}
