package com.thoughtworks.aceleradora.dominio;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Breadcrumb {
    private Set<Pagina> listaDoBreadcrumb;

    public Breadcrumb() {
        this.listaDoBreadcrumb = new HashSet<>();
    }

    public Set<Pagina> getListaDoBreadcrumb() {
        return listaDoBreadcrumb;
    }

    public void adicionaPagina(String nomeDaPagina, String urlDaPagina) {
        boolean adiciona = true;

        for (Pagina pagina : listaDoBreadcrumb) {
            if (pagina.getUrl().equals(urlDaPagina)) {
                adiciona = false;
            }
        }

        if (adiciona) {
            Pagina novaPagina = new Pagina(nomeDaPagina, urlDaPagina);
            listaDoBreadcrumb.add(novaPagina);
        }

    }

    public void removePagina(String nomeDaPagina, String urlDaPagina){
        Pagina paginaAntiga = new Pagina(nomeDaPagina, urlDaPagina);
        listaDoBreadcrumb.remove(paginaAntiga);

    }
}
