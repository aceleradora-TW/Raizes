package com.thoughtworks.aceleradora.dominio;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="produtos")
@Access(AccessType.FIELD)
public class Produto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "lista_produtos",
            joinColumns = { @JoinColumn(name = "id_produto") },
            inverseJoinColumns = { @JoinColumn(name = "id_lista") }
    )
    @JsonIgnoreProperties("produtos")
    private List<MinhaLista> listas = new ArrayList<>();

    public Produto(){}

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public List<MinhaLista> getListas() {
        return listas;
    }

    public void setListas(List<MinhaLista> listas) {
        this.listas = listas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

