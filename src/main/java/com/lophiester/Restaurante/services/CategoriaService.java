package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Categoria;
import com.lophiester.Restaurante.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(null);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Categoria obj) {
        obj.setId(obj.getId());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        categoriaRepository.deleteById(id);
    }
}
