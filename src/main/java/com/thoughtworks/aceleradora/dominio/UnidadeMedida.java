package com.thoughtworks.aceleradora.dominio;

public enum UnidadeMedida {
    QUILOGRAMA ("Kg"),
    LITRO("L"),
    UNIDADE ("Un"),
    GRAMA ("g"),
    MILILITRO ("ml");

    private String codigo;

    UnidadeMedida() {
    }

    UnidadeMedida(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo(){
        return codigo;
    }
}
