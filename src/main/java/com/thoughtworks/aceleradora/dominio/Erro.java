package com.thoughtworks.aceleradora.dominio;

public class Erro {
    private String mensagem;
    private boolean estado;

    public Erro(String mensagem, boolean estado) {
        this.mensagem = mensagem;
        this.estado = estado;
    }
}
