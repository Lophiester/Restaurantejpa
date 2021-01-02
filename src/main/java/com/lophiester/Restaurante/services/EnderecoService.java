package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Endereco;
import com.lophiester.Restaurante.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco buscar(Integer id) {
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(null);
    }
}
