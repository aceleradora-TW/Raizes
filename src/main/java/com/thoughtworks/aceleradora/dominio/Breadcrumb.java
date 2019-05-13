package com.thoughtworks.aceleradora.dominio;

import java.util.ArrayList;
import java.util.List;


public class Breadcrumb {
    private List<Pagina> listaDoBreadcrumb;

    public Breadcrumb() {
        this.listaDoBreadcrumb = new ArrayList<>();
    }

    public List<Pagina> getListaDoBreadcrumb() {
        return listaDoBreadcrumb;
    }

    public void setListaDoBreadcrumb(List<Pagina> listaDoBreadcrumb) {
        this.listaDoBreadcrumb = listaDoBreadcrumb;
    }

    public void adicionaPagina(String nomeDaPagina, String urlDaPagina) {
        for (Pagina pagina : listaDoBreadcrumb) {
            if (!pagina.getNome().equalsIgnoreCase(nomeDaPagina)) {
                Pagina novaPagina = new Pagina(nomeDaPagina, urlDaPagina);
                listaDoBreadcrumb.add(pagina);
            }
        }

    }
}
