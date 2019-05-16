package com.thoughtworks.aceleradora.dominio;

import java.util.Objects;

public class Pagina {

    private final String titulo;
    private final String url;

    public Pagina(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagina pagina = (Pagina) o;
        return Objects.equals(titulo, pagina.titulo) &&
                Objects.equals(url, pagina.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, url);
    }

    public String toString() {
        return titulo;
    }

}
