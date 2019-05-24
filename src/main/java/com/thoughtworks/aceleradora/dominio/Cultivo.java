package com.thoughtworks.aceleradora.dominio;


import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "tipos_de_cultivos")
@Access(AccessType.FIELD)
public class Cultivo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "cultivo")
    @OrderBy(value="nome")
    private List<Produto> produtos;

    public Cultivo(){
    }

    public Cultivo(String nome) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
