package com.lophiester.Restaurante.domain.dto;

import com.lophiester.Restaurante.domain.Cliente;
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
public class ClienteDTO implements Serializable {

    private Integer id;
    @NotEmpty
    @Length(min = 5, max = 120)
    private String nome;
    @NotEmpty
    @Email
    private String email;

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }


}
