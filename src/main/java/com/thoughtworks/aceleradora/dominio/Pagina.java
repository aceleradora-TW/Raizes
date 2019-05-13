package com.thoughtworks.aceleradora.dominio;

public class Pagina {
    private String nome;
    private String url;

    public Pagina(String nome, String url) {
        this.url = url;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }


}
