package com.thoughtworks.aceleradora.dominio;

public enum TipoDeCultivo {
    ORGANICO("Organico"),
    CONVENCIONAL("Convencional"),
    HIDROPONICO("Hidroponico");

    private String codigo;

    TipoDeCultivo() {
    }

    TipoDeCultivo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}