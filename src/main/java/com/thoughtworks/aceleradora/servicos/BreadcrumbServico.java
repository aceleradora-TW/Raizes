package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Pagina;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class BreadcrumbServico {
     private Breadcrumb breadcrumb = new Breadcrumb();

    public String renderizaBreadcrumb(String nomeDaPagina, String nomeHtml, String urlDaPagina, Model modelo) {
        List<Pagina> listaDoBreadcrumb = breadcrumb.getListaDoBreadcrumb();
        breadcrumb.adicionaPagina(nomeDaPagina, urlDaPagina);

        modelo.addAttribute("listaDePaginas", listaDoBreadcrumb);

        return nomeHtml;

    }

//     public String criaBreadcrumb (String nomeDaPagina, String nomeHtml, String urlDaPagina, Model modelo) {
//         List<Pagina> listaDoBreadcrumb = breadcrumb.getListaDoBreadcrumb();
//
//         if(!listaDoBreadcrumb.contains(nomeDaPagina)){
//             Pagina pagina = new Pagina(nomeDaPagina, urlDaPagina);
//             listaDoBreadcrumb.add(pagina);
//
//         }
//         modelo.addAttribute("listaDePaginas", this.listaDoBreadcrumb);
//
//         return nomeHtml;
//     }




}
