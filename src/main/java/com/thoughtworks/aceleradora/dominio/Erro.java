package com.thoughtworks.aceleradora.dominio;

public class Erro {
    private String mensagem;
    private boolean estado;

    public Erro(){}

    public Erro(String mensagem, boolean estado) {
        this.mensagem = mensagem;
        this.estado = estado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
