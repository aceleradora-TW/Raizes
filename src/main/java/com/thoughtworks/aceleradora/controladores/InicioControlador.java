package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Pagina;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InicioControlador {

    @GetMapping("/")
    public String renderizaPaginaInicial(Model modelo, Breadcrumb breadcrumb) {
        List<Pagina> nomes = new ArrayList<>();
        Pagina paginaInicial = new Pagina("Página Inicial");
        Pagina criarLista = new Pagina("Criar Lista");

        nomes.add(paginaInicial);
        nomes.add(criarLista);

        breadcrumb.setListaDePaginas(nomes);

        modelo.addAttribute("rotas", breadcrumb);

        return "inicio";
    }
}
