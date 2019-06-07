package com.thoughtworks.aceleradora.dominio;

public enum TipoDeCultivo {
    ORGANICO("organico"),
    CONVENCIONAL("convencional"),
    HIDROPONICO("hidroponico");

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