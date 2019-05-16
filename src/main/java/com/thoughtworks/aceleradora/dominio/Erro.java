package com.thoughtworks.aceleradora.dominio;

public class Erro {
    private String mensagem;

    public Erro(){}

    public Erro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
