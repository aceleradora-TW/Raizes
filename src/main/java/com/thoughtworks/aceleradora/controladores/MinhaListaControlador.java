package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Consumer;

@Controller
@RequestMapping("/minhas-listas")
public class MinhaListaControlador {

    private MinhaListaServico minhaListaServico;
    private CategoriaServico categoriaServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página Inicial", "/");

    @Autowired
    public MinhaListaControlador(MinhaListaServico minhaListaServico, CategoriaServico categoriaServico) {
        this.minhaListaServico = minhaListaServico;
        this.categoriaServico = categoriaServico;
    }

    @GetMapping
    public String listasCriadas(Breadcrumb breadcrumb, Model modelo) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Minhas Listas", "/minha-lista/listas-criadas");

        modelo.addAttribute("listasCriadas", minhaListaServico.pegarListasCriadas());

        return "minha-lista/listas-criadas";
    }

    @GetMapping("/criar")
    public String criarLista(Breadcrumb breadcrumb, Model modelo) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Minhas Listas", "/minhas-listas")
                .pagina("Cadastro", "/minhas-listas/cadastro");

        modelo.addAttribute("categorias", categoriaServico.pegarCategorias());
        modelo.addAttribute("minhaLista", new MinhaLista());

        return "minha-lista/cadastro";
    }

    @PostMapping("/criar")
    public String salvarLista(@Valid MinhaLista minhaLista, BindingResult resultadoValidacao, Model modelo, RedirectAttributes redirecionamentoDeAtributos) {
        if(resultadoValidacao.hasErrors()) {
            modelo.addAttribute("erros", resultadoValidacao.getAllErrors());
            modelo.addAttribute("categorias", categoriaServico.pegarCategorias());

            return "minha-lista/cadastro";
        }

        minhaListaServico.salvar(minhaLista);

        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Lista criada com sucesso");

        return "redirect:/minhas-listas";
    }

    @PostMapping("/{id}/excluir")
    public String removerListaCriada(@PathVariable("id") Long id) {
        minhaListaServico.removerListaCriada(id);

        return "redirect:/minhas-listas";
    }

    @GetMapping("/{id}/editar")
    public String pegaLista(@PathVariable("id") Long id, Breadcrumb breadcrumb, RedirectAttributes redirecionamentoDeAtributos, Model modelo) {
        breadcrumb
            .aproveitar(partesComunsDoBreadCrumb)
            .pagina("Editar lista", "/minha-lista/editar-lista/{id}");

        try {
            modelo.addAttribute("minhaLista", minhaListaServico.encontraUm(id));
            modelo.addAttribute("categorias", categoriaServico.pegarCategorias());

            return "minha-lista/editar";
        } catch (ListaNaoEncontradaExcecao e) {
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());

            return "redirect:/minhas-listas/";
        }
    }


    @PostMapping("/{id}/editar")
    public String salvarLista(@Valid MinhaLista minhaLista, BindingResult resultadoValidacao, RedirectAttributes redirecionamentoDeAtributos, Model modelo) {
        if (resultadoValidacao.hasErrors()) {
            modelo.addAttribute("erros", resultadoValidacao.getAllErrors());
            modelo.addAttribute("categorias", categoriaServico.pegarCategorias());

            return "minha-lista/editar";
        }

        minhaListaServico.salvar(minhaLista);
        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Lista atualizada com sucesso");

        return "redirect:/minhas-listas";
    }
}