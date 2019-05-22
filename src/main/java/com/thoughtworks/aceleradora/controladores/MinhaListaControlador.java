package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Categoria;
import com.thoughtworks.aceleradora.dominio.Erro;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.function.Consumer;

@Controller
@RequestMapping("/minha-lista")
public class MinhaListaControlador {

    private ProdutoServico produtoServico;
    private MinhaListaServico minhaListaServico;
    private CategoriaServico categoriaServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");


    @Autowired
    public MinhaListaControlador(ProdutoServico produtoServico, MinhaListaServico minhaListaServico, CategoriaServico categoriaServico) {
        this.produtoServico = produtoServico;
        this.minhaListaServico = minhaListaServico;
        this.categoriaServico = categoriaServico;
    }


    @GetMapping("/cadastro")
    public String criarLista(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Cadastro", "/minha-lista/cadastro");

        modelo.addAttribute("lista", new MinhaLista());
        List<Categoria> categorias = categoriaServico.pegarCategorias();
        modelo.addAttribute("categorias", categorias);

        return "minhaLista/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarLista(MinhaLista lista, Breadcrumb breadcrumb, RedirectAttributes atributosRedirecionamento) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Cadastro", "/minha-lista/cadastro");
        if(minhaListaServico.salvar(lista) == null) {
            Erro erro = new Erro("Falhou na criação da lista");
            atributosRedirecionamento.addFlashAttribute("Erro", erro);

            return "redirect:/minha-lista/cadastro";
        }
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/pegarCategorias")
    public List<Categoria> salvarLista() {
        return categoriaServico.pegarCategorias();
    }

    @GetMapping("/listas-criadas")
    public String listasCriadas(Model modelo, Breadcrumb breadcrumb, RedirectAttributes atributosRedirecionamento) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Minhas Listas", "/minha-lista/listas-criadas");

        if(minhaListaServico.pegarListasCriadas() == null) {
            Erro erro = new Erro("Não há nenhuma lista criada.");
            atributosRedirecionamento.addFlashAttribute("Erro", erro);
            return "minhaLista/listas-criadas";
        }
        modelo.addAttribute("listasCriadas", minhaListaServico.pegarListasCriadas());
        return "minhaLista/listas-criadas";
    }

    @PostMapping("/listas-criadas/excluir/{id}")
    public String removerListaCriada(MinhaLista lista, @PathVariable ("id") Long id) {
        minhaListaServico.removerListaCriada(id);
        return "redirect:/minha-lista/listas-criadas";
    }
}


