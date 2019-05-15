package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Pagina;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Set;

@Service
public class BreadcrumbServico {
     private Breadcrumb breadcrumb = new Breadcrumb();

    public String renderizaBreadcrumb(String nomeDaPagina, String nomeHtml, String urlDaPagina, Model modelo) {
        Set<Pagina> listaDoBreadcrumb = breadcrumb.getListaDoBreadcrumb();
        breadcrumb.adicionaPagina(nomeDaPagina, urlDaPagina);

        modelo.addAttribute("listaDePaginas", listaDoBreadcrumb);
        modelo.addAttribute("listaDePaginas2", breadcrumb.pegaPaginaAtual(nomeDaPagina));

        return nomeHtml;
    }
}
