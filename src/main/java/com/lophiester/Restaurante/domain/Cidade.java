package com.lophiester.Restaurante.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nome;
    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;


    public Cidade(Integer id, String nome, Provincia provincia) {
        this.id = id;
        Nome = nome;
        this.provincia = provincia;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cidade cidade = (Cidade) o;

        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
