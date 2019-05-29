package com.thoughtworks.aceleradora.controladores;


import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Categoria;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import com.thoughtworks.aceleradora.servicos.ProdutorServicoTeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.function.Consumer;

@Controller
@RequestMapping("/teste")
public class ProdutosProdutoresControladorTeste {
    private ProdutoServico produtoServico;
    private ProdutorServicoTeste produtorServicoTeste;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");

    @Autowired
    public ProdutosProdutoresControladorTeste(ProdutoServico produtoServico, ProdutorServicoTeste produtorServicoTeste) {
        this.produtoServico = produtoServico;
        this.produtorServicoTeste = produtorServicoTeste;
    }

    @GetMapping
    public String listaProdutosProdutores(Model modelo){
        modelo.addAttribute("produtos", produtoServico.pegarTodos());
        modelo.addAttribute("produtores", produtorServicoTeste.pegarTodosProdutores());

        return "pedido/teste";
    }

    @ResponseBody
    @GetMapping("/pegarProdutosProdutores")
    public List<Produtor> mostrarProdutosProdutor() {

        return produtorServicoTeste.pegarTodosProdutores();
    }



    /*
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


     */


}
