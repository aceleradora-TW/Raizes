package com.thoughtworks.aceleradora.dominio;

@SuppressWarnings("unused")
public enum TipoDeUsuario {
    CLIENTE(Valores.CLIENTE), PRODUTOR(Valores.PRODUTOR);

    public String valor;

    TipoDeUsuario(String valor) {
        this.valor = valor;
    }

    public static class Valores {
        static final String CLIENTE = "CLIENTE";
        static final String PRODUTOR = "PRODUTOR";
    }
}


