package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Erro;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.CultivoServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Consumer;

@Controller
@RequestMapping("/produtos")
public class ProdutoControlador {

    private ProdutoServico produtoServico;
    private CategoriaServico categoriaServico;
    private CultivoServico cultivoServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");

    @Autowired
    public ProdutoControlador(ProdutoServico produtoServico, CategoriaServico categoriaServico, CultivoServico cultivoServico) {
        this.produtoServico = produtoServico;
        this.categoriaServico = categoriaServico;
        this.cultivoServico = cultivoServico;
    }

    @GetMapping("/cadastro")
    public String cadastrarProduto(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");

        modelo.addAttribute("categorias",categoriaServico.pegarCategorias());
        modelo.addAttribute("cultivos", cultivoServico.pegarCultivos());

        return "produto/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarProduto (Produto produtoQueVem, Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");

        if (!produtoQueVem.getNome().trim().isEmpty()) {

            produtoServico.salvar(produtoQueVem);

            String mensagem = "Seu produto foi cadastrado com sucesso!";
            modelo.addAttribute("mensagemSalvoComSucesso", mensagem);
        } else {
            Erro erro = new Erro("Erro ao salvar seu produto!");
            modelo.addAttribute("erro", erro);
        }

        return "produto/cadastro";
    }
}