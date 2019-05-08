package com.thoughtworks.aceleradora.dominio;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "categorias")
@Access(AccessType.FIELD)
public class Categoria {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;

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

    public void setNome(String nome) {
        this.nome = nome;
    }
}
