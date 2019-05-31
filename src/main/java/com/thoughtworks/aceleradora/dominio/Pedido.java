package com.thoughtworks.aceleradora.dominio;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "pedidos")
@Access(AccessType.FIELD)
public class Pedido{
    private String nome;


    public Pedido(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
