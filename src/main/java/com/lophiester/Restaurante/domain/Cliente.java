package com.lophiester.Restaurante.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;


    @ElementCollection
    @CollectionTable(name = "TELEFONES")
    private Set<String> telefones = new HashSet<>();
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



}