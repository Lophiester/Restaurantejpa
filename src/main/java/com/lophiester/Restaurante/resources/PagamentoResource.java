package com.lophiester.Restaurante.resources;

import com.lophiester.Restaurante.domain.Pagamento;
import com.lophiester.Restaurante.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Pagamento obj = pagamentoService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
