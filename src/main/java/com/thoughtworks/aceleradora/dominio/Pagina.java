package com.thoughtworks.aceleradora.dominio;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagina pagina = (Pagina) o;
        return Objects.equals(nome, pagina.nome) &&
                Objects.equals(url, pagina.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, url);
    }
}
