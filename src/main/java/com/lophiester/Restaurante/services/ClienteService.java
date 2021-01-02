package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Cliente;
import com.lophiester.Restaurante.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(null);
    }
}
