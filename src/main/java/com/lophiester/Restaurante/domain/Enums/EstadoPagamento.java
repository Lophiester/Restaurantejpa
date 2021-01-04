package com.lophiester.Restaurante.domain.Enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUIATADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private Integer cod;
    private String descricao;

    EstadoPagamento() {
    }

    EstadoPagamento(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) {
        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("cod invalido" + cod);
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
