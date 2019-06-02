package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dtos.CategoriaDTO;
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
@RequestMapping("/minhas-listas")
public class MinhaListaControlador {

    private ProdutoServico produtoServico;
    private MinhaListaServico minhaListaServico;
    private CategoriaServico categoriaServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página Inicial", "/");

    @Autowired
    public MinhaListaControlador(ProdutoServico produtoServico, MinhaListaServico minhaListaServico, CategoriaServico categoriaServico) {
        this.produtoServico = produtoServico;
        this.minhaListaServico = minhaListaServico;
        this.categoriaServico = categoriaServico;
    }

    @GetMapping
    public String listasCriadas(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Minhas Listas", "/minha-lista/listas-criadas");
        modelo.addAttribute("listasCriadas", minhaListaServico.pegarListasCriadas());
        return "minha-lista/listas-criadas";
    }

    @GetMapping("/criar")
    public String criarLista(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Minhas Listas", "/minhas-listas")
                .pagina("Cadastro", "/minhas-listas/cadastro");

        modelo.addAttribute("lista", new MinhaLista());
        List<Categoria> categorias = categoriaServico.pegarCategorias();
        modelo.addAttribute("categorias", categorias);

        return "minha-lista/cadastro";
    }

    @PostMapping("/criar")
    public String salvarLista(MinhaLista lista, RedirectAttributes atributosRedirecionamento) {
        if (minhaListaServico.salvar(lista) == null) {
            Erro erro = new Erro("Já existe uma lista cadastrada com esse nome!");
            atributosRedirecionamento.addFlashAttribute("Erro", erro);

            return "redirect:/minhas-listas/criar";
        }

        return "redirect:/minhas-listas";
    }

    @ResponseBody
    @GetMapping("/pegarCategorias")
    public List<Categoria> salvarLista() {
        return categoriaServico.pegarCategorias();
    }

    @PostMapping("/{id}/excluir")
    public String removerListaCriada(MinhaLista lista, @PathVariable("id") Long id) {
        minhaListaServico.removerListaCriada(id);
        return "redirect:/minhas-listas";
    }

    @GetMapping("/{id}/editar/")
    public String pegaLista(Model modelo, @PathVariable("id") Long id, Breadcrumb breadcrumb, RedirectAttributes redirecionamentoDeAtributos) {
        MinhaLista listaExistente = minhaListaServico.encontraUm(id);

        breadcrumb
            .aproveitar(partesComunsDoBreadCrumb)
            .pagina("editar lista", "/minha-lista/editar-lista/{id}");

        if (listaExistente == null) {
            Erro erro = new Erro("Lista inexistente.");
            redirecionamentoDeAtributos.addFlashAttribute("erro", erro);
            return "redirect:/minhas-listas/";
        }

        List<CategoriaDTO> categorias = categoriaServico.pegarCategoriasDto();
        categorias = categoriaServico.setaChecados(categorias, listaExistente.getProdutos());

        modelo.addAttribute("categorias", categorias);
        modelo.addAttribute("lista", listaExistente);

        return "minha-lista/editar";
    }


    @PostMapping("/{id}/editar")
    public String salvarLista(MinhaLista listaDoFront, @PathVariable("id") Long id, RedirectAttributes redirecionamentoDeAtributos) {
        MinhaLista listaDoBanco = minhaListaServico.encontraUm(id);
        Erro erro = new Erro("Erro ao salvar a lista!");

        if (listaDoBanco == null) {
            erro.setMensagem("Lista inexistente.");
            redirecionamentoDeAtributos.addFlashAttribute("erro", erro);
            return "redirect:/minhas-listas/";
        }

        if (listaDoFront.getNome().trim().isEmpty()) {
            erro.setMensagem("Nome da lista é obrigatório.");
            redirecionamentoDeAtributos.addFlashAttribute("erro", erro);
            return "redirect:/minhas-listas/{id}/editar/";
        }

        List<Produto> produtosFront = listaDoFront.getProdutos();

        if (produtosFront.size() == 0) {
            erro.setMensagem("Selecione pelo menos 1 produto.");
            redirecionamentoDeAtributos.addFlashAttribute("erro", erro);
            return "redirect:/minhas-listas/{id}/editar/";
        }

        listaDoBanco.setNome(listaDoFront.getNome());
        listaDoBanco.setProdutos(produtosFront);
        minhaListaServico.salvar(listaDoBanco);

        redirecionamentoDeAtributos.addFlashAttribute("mensagemSalvoComSucesso", "Sua lista foi salva com sucesso!");
        return "redirect:/minhas-listas";
    }
}