package com.lophiester.Restaurante.resources;

import com.lophiester.Restaurante.domain.Pedido;
import com.lophiester.Restaurante.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Pedido obj = pedidoService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
