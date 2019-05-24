package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                .pagina("Minhas Listas", "/minhas-listas");

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
            Erro erro = new Erro("Falhou na criação da lista");
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

    @GetMapping("/editar-lista/{id}")
    public String pegaLista(Model modelo, @PathVariable("id") Long id, Breadcrumb breadcrumb) {
        Optional<MinhaLista> lista = minhaListaServico.encontraUm(id);
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("editar lista", "/minha-lista/editar-lista/{id}");

        modelo.addAttribute("lista", lista.get());

        return "minha-lista/editar";
    }

    @PostMapping("/editar-lista/{id}/salvar")
    public String removerItem(MinhaLista listaDoFront, @PathVariable("id") Long id, RedirectAttributes redirecionamentoDeAtributos) {
        Optional<MinhaLista> listaDoBanco = minhaListaServico.encontraUm(id);
        List<Produto> produtosParaSeremRemovidos = new ArrayList<>();
        MinhaLista lista = listaDoBanco.get();

        if (listaDoBanco.isPresent()) {
            List<Produto> produtosDoBanco = lista.getProdutos();
            List<Produto> produtosFront = listaDoFront.getProdutos();
            Erro erro = new Erro("Erro ao salvar a lista!");

            if (listaDoFront.getNome().trim().isEmpty()) {
                redirecionamentoDeAtributos.addFlashAttribute("erro", erro);
                return "redirect:/minhas-listas/editar-lista/{id}";
            }

            for (Produto produto : produtosDoBanco) {
                if (!produtosFront.contains(produto)) {
                    produtosParaSeremRemovidos.add(produto);
                }
            }

            if (produtosDoBanco.size() == produtosParaSeremRemovidos.size() || !(produtoServico.removerTodos(produtosDoBanco, produtosParaSeremRemovidos))) {
                redirecionamentoDeAtributos.addFlashAttribute("erro", erro);
                return "redirect:/minhas-listas/editar-lista/{id}";
            }

            lista.setNome(listaDoFront.getNome());
            minhaListaServico.salvar(lista);

            String mensagemDeSucesso = "Sua lista foi salva com sucesso!";
            redirecionamentoDeAtributos.addFlashAttribute("mensagemSalvoComSucesso", mensagemDeSucesso);
        }
        return "redirect:/minhas-listas";
    }
}


