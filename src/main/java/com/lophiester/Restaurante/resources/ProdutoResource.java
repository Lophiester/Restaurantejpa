package com.lophiester.Restaurante.resources;

import com.lophiester.Restaurante.domain.Produto;
import com.lophiester.Restaurante.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
    @Autowired
    private ProdutoService produtoService;
@GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Produto obj = produtoService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
