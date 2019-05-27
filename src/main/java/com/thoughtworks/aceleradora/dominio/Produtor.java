package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtor")
@Access(AccessType.FIELD)
public class Produtor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    private boolean possuiTransporte;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "produtos_produtor",
            joinColumns = {@JoinColumn(name = "id_produtor")},
            inverseJoinColumns = {@JoinColumn(name = "id_produtos")}
    )

    @JsonIgnoreProperties("listas")
    private List<Produto> produtos = new ArrayList<>();

    public Produtor() {
    }

    public Produtor(String nome, List<Produto> produtos, boolean possuiTransporte) {
        this.nome = nome;
        this.produtos = produtos;
        this.possuiTransporte = possuiTransporte;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean isPossuiTransporte() {
        return possuiTransporte;
    }

    public void setPossuiTransporte(boolean possuiTransporte) {
        this.possuiTransporte = possuiTransporte;
    }
}

