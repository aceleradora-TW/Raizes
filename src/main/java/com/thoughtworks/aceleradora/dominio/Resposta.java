package com.thoughtworks.aceleradora.dominio;

public class Resposta<T> {
    private String mensagem;
    private T dados;

    public Resposta(){}

    public Resposta(String mensagem) {
        this.mensagem = mensagem;
    }

    public Resposta(String mensagem, T dados) {
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }


}
