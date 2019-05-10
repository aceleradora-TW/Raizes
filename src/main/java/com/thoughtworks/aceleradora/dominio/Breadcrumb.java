package com.thoughtworks.aceleradora.dominio;

import org.springframework.ui.Model;

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

    public List<Pagina> criaBreadcrumb (String nomeDaPagina, String urlDaPagina, Model modelo) {
        Pagina pagina = new Pagina(nomeDaPagina, urlDaPagina);
        listaDoBreadcrumb.add(pagina);

        return listaDoBreadcrumb;
    }
}
