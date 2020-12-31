package com.lophiester.Restaurante.resources;

import com.lophiester.Restaurante.domain.Categoria;
import com.lophiester.Restaurante.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Categoria obj = categoriaService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
