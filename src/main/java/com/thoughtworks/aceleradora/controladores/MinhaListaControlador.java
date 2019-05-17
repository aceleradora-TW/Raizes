package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.servicos.BreadcrumbServico;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/minha-lista")
public class MinhaListaControlador {

    private BreadcrumbServico breadcrumbServico;
    private ProdutoServico produtoServico;
    private MinhaListaServico minhaListaServico;

    @Autowired
    public MinhaListaControlador(ProdutoServico produtoServico, MinhaListaServico minhaListaServico, BreadcrumbServico breadcrumbServico) {
        this.produtoServico = produtoServico;
        this.minhaListaServico = minhaListaServico;
        this.breadcrumbServico = breadcrumbServico;
    }

    @GetMapping("/cadastro")
    public String criarLista(Model modelo) {
        modelo.addAttribute("produtos", produtoServico.pegarTodos());

        return this.breadcrumbServico.renderizaBreadcrumb("Criar Lista de Produtos",
                "minhaLista/cadastro",
                "/minha-lista/cadastro",
                modelo);
    }

    @PostMapping("/cadastro")
    public String salvarLista(MinhaLista lista) {

        minhaListaServico.salvar(lista);
        return "redirect:/minha-lista/listas-criadas";
    }


    @GetMapping("/listas-criadas")
    public String listasCriadas(Model modelo) {
        modelo.addAttribute("listasCriadas", minhaListaServico.pegarListasCriadas());

        return this.breadcrumbServico.renderizaBreadcrumb("Minhas listas",
                "minhaLista/listas-criadas",
                "/minha-lista/listas-criadas",
                modelo);
    }

    @PostMapping("/listas-criadas/excluir/{id}")
    public String removerListaCriada(MinhaLista lista, @PathVariable ("id") Long id) {
        minhaListaServico.removerListaCriada(id);
        return "redirect:/minha-lista/listas-criadas";
    }
}

