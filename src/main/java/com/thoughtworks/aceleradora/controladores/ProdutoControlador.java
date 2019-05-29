package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Erro;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.CultivoServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import com.thoughtworks.aceleradora.servicos.ProdutorServicoTeste;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Controller
@RequestMapping("/produtos")
public class ProdutoControlador {

    private ProdutoServico produtoServico;
    private CategoriaServico categoriaServico;
    private CultivoServico cultivoServico;
    private ProdutorServicoTeste produtorServicoTeste;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");

    @Autowired
    public ProdutoControlador(ProdutoServico produtoServico, CategoriaServico categoriaServico,
                              CultivoServico cultivoServico, ProdutorServicoTeste produtorServicoTeste) {
        this.produtoServico = produtoServico;
        this.categoriaServico = categoriaServico;
        this.cultivoServico = cultivoServico;
        this.produtorServicoTeste = produtorServicoTeste;
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

    @ResponseBody
    @GetMapping("/pegarProdutosProdutores")
    public List<Produtor> mostrarProdutosProdutor() {
        return produtorServicoTeste.pegarTodosProdutores();
    }

    @ResponseBody
    @GetMapping("/teste")
    public Map listaProdutosProdutores(Model modelo){
        Map<String, List> mapa = new HashMap<>();

        List<Produto> produtos = produtoServico.pegarTodos();
        List<Produtor> produtores = produtorServicoTeste.pegarTodosProdutores();

        mapa.put("produtos", produtos);
        mapa.put("produtores", produtores);

        return mapa;
    }

}