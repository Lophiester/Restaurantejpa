package com.lophiester.Restaurante.domain;

import com.lophiester.Restaurante.domain.Enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoEmDinheiro extends Pagamento{

    private Long valor;

    public PagamentoEmDinheiro(){}

    public PagamentoEmDinheiro(Integer id, EstadoPagamento estado, Pedido pedido, Long valor) {
        super(id, estado, pedido);
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
}
