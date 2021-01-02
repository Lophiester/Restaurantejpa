package com.lophiester.Restaurante.resources;

import com.lophiester.Restaurante.domain.Provincia;
import com.lophiester.Restaurante.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provincias")
public class ProvinciaResource {
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Provincia obj = provinciaService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
