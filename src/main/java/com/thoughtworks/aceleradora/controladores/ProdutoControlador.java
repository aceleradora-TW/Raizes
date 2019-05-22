package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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

    @GetMapping
    @ResponseBody
    public List<Produto> pegarProdutos() {
        return produtoServico.pegarTodos();
    }

    @GetMapping("/cadastro")
    public String cadastarProduto(Model modelo, Breadcrumb breadcrumb) {
            breadcrumb
                    .aproveitar(partesComunsDoBreadCrumb)
                    .pagina("Produtos", "/produtos")
                    .pagina("Cadastro", "/produtos/cadastro");

            return "produto/cadastro";
    }


}
