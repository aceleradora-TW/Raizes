package com.thoughtworks.aceleradora.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Breadcrumb {
    private Set<Pagina> listaDoBreadcrumb;

    public Breadcrumb() {
        this.listaDoBreadcrumb = new LinkedHashSet<>();
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
    public String pegaPaginaAtual(String nomeDaPagina){
        nomeDaPagina = null;

        for (Pagina pagina: listaDoBreadcrumb) {
            nomeDaPagina = pagina.getNome();
        }

        return nomeDaPagina;
    }

    public void removePagina(String nomeDaPagina, String urlDaPagina){
        Pagina paginaAntiga = new Pagina(nomeDaPagina, urlDaPagina);
        listaDoBreadcrumb.remove(paginaAntiga);

    }
}
