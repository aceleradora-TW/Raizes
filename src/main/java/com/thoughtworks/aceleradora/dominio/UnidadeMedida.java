package com.thoughtworks.aceleradora.dominio;

public enum UnidadeMedida {
    QUILOGRAMA("Kg"),
    LITRO("L"),
    UNIDADE("Un"),
    GRAMA("g"),
    MILILITRO("ml");

    private String simbolo;

    UnidadeMedida(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
