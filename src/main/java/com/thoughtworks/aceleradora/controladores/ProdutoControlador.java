package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoSalvoExcecao;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.function.Consumer;

@Controller
@RequestMapping("/produtos")
public class ProdutoControlador {

    private ProdutoServico produtoServico;
    private CategoriaServico categoriaServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");

    @Autowired
    public ProdutoControlador(ProdutoServico produtoServico, CategoriaServico categoriaServico) {
        this.produtoServico = produtoServico;
        this.categoriaServico = categoriaServico;
    }

    @GetMapping("/cadastro")
    public String cadastrarProduto(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");

        modelo.addAttribute("categorias", categoriaServico.pegarCategorias());
        modelo.addAttribute("cultivos", Arrays.asList(TipoDeCultivo.values()));
        modelo.addAttribute("produtos", produtoServico.pegarTodos());

        return "produto/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarProduto (Produto produto, Model modelo, Breadcrumb breadcrumb, RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");
        try {
            produto.setNome(produto.getNome().trim());
            produtoServico.salvar(produto);

            String mensagem = "Seu produto foi cadastrado com sucesso!";
            modelo.addAttribute("mensagemSalvoComSucesso", mensagem);
        } catch (ProdutoNaoSalvoExcecao e){
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());

            return "redirect:/produtos/cadastro";
        }

        return "redirect:/produtos/cadastro";
    }

}