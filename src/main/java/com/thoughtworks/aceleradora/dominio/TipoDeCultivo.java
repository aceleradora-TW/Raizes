package com.thoughtworks.aceleradora.dominio;

public enum TipoDeCultivo {
    ORGANICO("Orgânico"),
    CONVENCIONAL("Convencional"),
    HIDROPONICO("Hidropônico");

    private String codigo;

    TipoDeCultivo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}