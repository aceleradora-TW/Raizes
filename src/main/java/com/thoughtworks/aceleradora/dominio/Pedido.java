package com.thoughtworks.aceleradora.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;


    public Pedido() {
    }

    public Pedido(String nome, long id) {
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
