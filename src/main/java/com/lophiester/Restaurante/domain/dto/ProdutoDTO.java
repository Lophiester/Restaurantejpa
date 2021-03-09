package com.lophiester.Restaurante.domain.dto;

import com.lophiester.Restaurante.domain.Produto;

public class ProdutoDTO {

    private Integer id;
    private String nome;
    private Long preco;

    public ProdutoDTO() {
    }
    public ProdutoDTO(Produto obj) {
        id= obj.getId();
        nome= obj.getNome();
        preco= obj.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }
}
