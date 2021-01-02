package com.lophiester.Restaurante.resources;

import com.lophiester.Restaurante.domain.Endereco;
import com.lophiester.Restaurante.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Endereco obj = enderecoService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
