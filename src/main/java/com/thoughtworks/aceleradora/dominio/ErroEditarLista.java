package com.thoughtworks.aceleradora.dominio;

public class ErroEditarLista {
    String mensagemAoSalvar;

    public ErroEditarLista(){

    }

    public ErroEditarLista(String mensagemAoSalvar) {
        this.mensagemAoSalvar = mensagemAoSalvar;
    }

    public String getMensagem() {
        return mensagemAoSalvar;
    }

    public void setMensagem(String mensagem) {
        this.mensagemAoSalvar = mensagem;
    }
}
