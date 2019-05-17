package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Consumer;

@Controller
@RequestMapping("/minha-lista")
public class MinhaListaControlador {

    private ProdutoServico produtoServico;
    private MinhaListaServico minhaListaServico;
    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");


    @Autowired
    public MinhaListaControlador(ProdutoServico produtoServico, MinhaListaServico minhaListaServico) {
        this.produtoServico = produtoServico;
        this.minhaListaServico = minhaListaServico;
    }


    @GetMapping("/cadastro")
    public String criarLista(Model model, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Cadastro", "/minha-lista/cadastro");

        model.addAttribute("produtos", produtoServico.pegarTodos());
        return "minhaLista/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarLista(MinhaLista lista, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Cadastro", "/minha-lista/cadastro");

        minhaListaServico.salvar(lista);
        return "minhaLista/cadastro";
    }

    @GetMapping("/listas-criadas")
    public String listasCriadas(Model modelo) {

        modelo.addAttribute("listasCriadas", minhaListaServico.pegarListasCriadas());
        return "minhaLista/listas-criadas";
    }

    @PostMapping("/listas-criadas/excluir/{id}")
    public String removerListaCriada(MinhaLista lista, @PathVariable ("id") Long id) {
        minhaListaServico.removerListaCriada(id);
        return "redirect:/minha-lista/listas-criadas";
    }
}

