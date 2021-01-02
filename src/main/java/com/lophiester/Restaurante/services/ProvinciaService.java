package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Provincia;
import com.lophiester.Restaurante.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinciaService {
    @Autowired
    private ProvinciaRepository provinciaRepository;

    public Provincia buscar(Integer id) {
        Optional<Provincia> obj = provinciaRepository.findById(id);
        return obj.orElseThrow(null);
    }
}
