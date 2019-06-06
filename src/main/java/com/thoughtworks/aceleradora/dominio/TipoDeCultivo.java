package com.thoughtworks.aceleradora.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<String> pegaTodos() {
        List<String> tiposDeCultivos = new ArrayList<>();
        for (TipoDeCultivo tipoDeCultivo : TipoDeCultivo.values()) {
            tiposDeCultivos.add(tipoDeCultivo.getCodigo());
        }
        return tiposDeCultivos;
    }

    public List<TipoDeCultivo> teste(){
        List<TipoDeCultivo> somethingList = Arrays.asList(TipoDeCultivo.values());
        return somethingList;
    }


}