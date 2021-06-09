package com.lophiester.Restaurante.domain.dto;

import com.lophiester.Restaurante.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {

    private Integer id;
    private String nome;
    private Long preco;


    public ProdutoDTO(Produto obj) {
        id= obj.getId();
        nome= obj.getNome();
        preco= obj.getPreco();
    }

}
