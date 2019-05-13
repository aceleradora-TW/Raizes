package com.thoughtworks.aceleradora.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
//        for (Pagina pagina : listaDoBreadcrumb) {
//            String nome = pagina.getNome();
//
//            if (!nome.equals(nomeDaPagina)) {
//                Pagina novaPagina = new Pagina(nomeDaPagina, urlDaPagina);
//                listaDoBreadcrumb.add(novaPagina);
//            }
//        }
        Pagina novaPagina = new Pagina(nomeDaPagina, urlDaPagina);
               listaDoBreadcrumb.add(novaPagina);

    }



}
