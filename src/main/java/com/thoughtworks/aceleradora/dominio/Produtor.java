package com.thoughtworks.aceleradora.dominio;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtores")
@Access(AccessType.FIELD)
public class Produtor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private boolean possuiTransporte;

    @ManyToOne
    @JoinColumn(name = "id_enderecos")
    private Endereco endereco;

    public Produtor() {
    }

    public Produtor(String nome, boolean possuiTransporte, Endereco endereco) {
        this.nome = nome;
        this.possuiTransporte = possuiTransporte;
        this.endereco = endereco;
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

    public boolean isPossuiTransporte() {
        return possuiTransporte;
    }

    public void setPossuiTransporte(boolean possuiTransporte) {
        this.possuiTransporte = possuiTransporte;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

