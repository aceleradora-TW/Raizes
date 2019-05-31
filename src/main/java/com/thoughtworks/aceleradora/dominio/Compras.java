package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Compras")
public class Compras {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;


    public Compras() {
    }

    public Compras(String nome, long id) {
        this.nome = nome;
        this.id = id;
    }

    public void setId(Long id) { this.id = id; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() { return nome; }




}
