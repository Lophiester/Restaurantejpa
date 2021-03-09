package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Categoria;
import com.lophiester.Restaurante.domain.Produto;
import com.lophiester.Restaurante.repositories.CategoriaRepository;
import com.lophiester.Restaurante.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(null);
    }

    public Page<Produto> findPage(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, Sort.Direction direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, direction, orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
    }

}
