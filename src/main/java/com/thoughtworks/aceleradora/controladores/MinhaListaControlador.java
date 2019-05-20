package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.ErroEditarLista;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        return "redirect:/minha-lista/listas-criadas";
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
    @GetMapping("/editar-lista/{id}")
    public String pegaLista(Model modelo, @PathVariable("id") Long id, Breadcrumb breadcrumb) {
        Optional<MinhaLista> lista = minhaListaServico.encontraUm(id);
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("editar lista", "/minha-lista/editar-lista/{id}");

        modelo.addAttribute("lista", lista.get());

        return "minhaLista/editar";
    }

    @PostMapping("/editar-lista/{id}")
    public String erroAoSalvar(MinhaLista lista, RedirectAttributes redirecionamentoDeAtributos) {
        if(minhaListaServico.salvar(lista) == null) {
            ErroEditarLista erro = new ErroEditarLista("Erro ao salvar a lista!");
            redirecionamentoDeAtributos.addFlashAttribute("ErroEditar", erro);

            return "redirect:/minha-lista/editar";
        }

        return "redirect:/minha-lista/listas-criadas";
    }

    @PostMapping("/editar-lista/{id}/salvar")
    public String removerItem(MinhaLista ListaDoFronte, @PathVariable("id") Long id, RedirectAttributes redirecionamentoDeAtributos) {
        Optional<MinhaLista> ListaDoBanco = minhaListaServico.encontraUm(id);
        List<Produto> produtosParaSeremRemovidos = new ArrayList<>();
        MinhaLista lista = ListaDoBanco.get();
        if (ListaDoBanco.isPresent()) {
            List<Produto> ProdutosDoBanco = ListaDoBanco.get().getProdutos();
            List<Produto> produtosFront = ListaDoFronte.getProdutos();

            for(Produto produtoDoBanco : ProdutosDoBanco) {
                if (!produtosFront.contains(produtoDoBanco)) {
                    produtosParaSeremRemovidos.add(produtoDoBanco);
                }
            }

            lista.getProdutos().removeAll(produtosParaSeremRemovidos);
            lista.setNome(ListaDoFronte.getNome());


            if(minhaListaServico.salvar(ListaDoBanco.get()) == null) {
                ErroEditarLista erro = new ErroEditarLista("Erro ao salvar a lista!");
                redirecionamentoDeAtributos.addFlashAttribute("ErroEditar", erro);

                return "redirect:/minha-lista/editar";
            }
        }

        return "minhaLista/cadastro";
    }
}

