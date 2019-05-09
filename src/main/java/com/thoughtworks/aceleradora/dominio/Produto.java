package com.thoughtworks.aceleradora.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtos")
@Access(AccessType.FIELD)
public class Produto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "produtos")
    private List<MinhaLista> listas = new ArrayList<>();

    public Produto() { }

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<MinhaLista> getListas() {
        return listas;
    }

    public void setListas(List<MinhaLista> listas) {
        this.listas = listas;
    }

}

