package com.lophiester.Restaurante.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ClienteNewDTO implements Serializable {
    @NotEmpty
    @Length(min = 5, max = 120)
    private String nome;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String senha;

    private String bairro;
    private String complemento;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;


}
