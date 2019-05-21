package com.thoughtworks.aceleradora.login.dominio;

public enum TipoDeUsuario {
    PRODUTOR("Produtor"),
    RESTAURANTEIRO("Restauranteiro");

    private String nome;

    TipoDeUsuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
