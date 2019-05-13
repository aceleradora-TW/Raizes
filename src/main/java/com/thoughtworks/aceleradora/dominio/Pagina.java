package com.thoughtworks.aceleradora.dominio;

public class Pagina {
    private String nome;
    private String url;

    public Pagina(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }
}
