package com.thoughtworks.aceleradora.dominio;

import java.util.Objects;

public class Pagina{
    private String nome;
    private String url;
    private int id;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagina pagina = (Pagina) o;
        return id == pagina.id &&
                nome.equals(pagina.nome) &&
                url.equals(pagina.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, url, id);
    }

}
