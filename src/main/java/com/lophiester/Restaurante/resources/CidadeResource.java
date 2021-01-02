package com.lophiester.Restaurante.resources;

import com.lophiester.Restaurante.domain.Cidade;
import com.lophiester.Restaurante.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Cidade obj = cidadeService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
