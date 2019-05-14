package com.thoughtworks.aceleradora.dominio;

import java.util.HashSet;
import java.util.Set;


public class Breadcrumb {
    private Set<Pagina> listaDoBreadcrumb;

    public Breadcrumb() {
        this.listaDoBreadcrumb = new HashSet<>();
    }

    public Set<Pagina> getListaDoBreadcrumb() {
        return listaDoBreadcrumb;
    }

    public void setListaDoBreadcrumb(Set<Pagina> listaDoBreadcrumb) {
        this.listaDoBreadcrumb = listaDoBreadcrumb;
    }

    public void adicionaPagina(String nomeDaPagina, String urlDaPagina) {
        Pagina novaPagina = new Pagina(nomeDaPagina, urlDaPagina);
        listaDoBreadcrumb.add(novaPagina);
    }

    public void removePagina(String nomeDaPagina, String urlDaPagina){
        Pagina paginaAntiga = new Pagina(nomeDaPagina, urlDaPagina);
        listaDoBreadcrumb.remove(paginaAntiga);

    }
}
