package com.thoughtworks.aceleradora.dominio;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "categorias")
@Access(AccessType.FIELD)
public class Categoria {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "categoria")
    @OrderBy(value="nome")
    @JsonIgnore()
    @JsonIgnoreProperties("categorias")
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
