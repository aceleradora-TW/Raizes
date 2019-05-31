package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.servicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private ProdutoServico produtoServico;
    private ProdutorServico produtorServico;
    private PedidoServico pedidoServico;
    private MinhaListaServico minhaListaServico;
    private ProdutoProdutorServico produtoProdutorServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");

    @Autowired
    public PedidoControlador(ProdutoServico produtoServico,
                             ProdutorServico produtorServico,
                             PedidoServico pedidoServico,
                             MinhaListaServico minhaListaServico,
                             ProdutoProdutorServico produtoProdutorServico) {
        this.produtoServico = produtoServico;
        this.produtorServico = produtorServico;
        this.pedidoServico = pedidoServico;
        this.minhaListaServico = minhaListaServico;
        this.produtoProdutorServico = produtoProdutorServico;
    }

    @GetMapping
    public String pedidos(Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedido/pedidos");
        return "pedido/pedidos";
    }

    @GetMapping("/{id}")
    public String visualizarPedido(@PathVariable("id") Long id, Model modelo, Breadcrumb breadcrumb) {
        MinhaLista lista = minhaListaServico.encontraUm(id);
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Visualizar pedido", "/pedidos");

        modelo.addAttribute("lista", lista);
        return "pedido/visualizar-pedido";
    }

    @GetMapping("/realizar-pedido")
    public String realizarPedidos(Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Realizar Pedido", "/pedido/pedidos");
        return "pedido/realizar-pedido";
    }

    @ResponseBody
    @GetMapping("/teste")
    public Map listaProdutosProdutores(Model modelo) {
        Map<String, List> mapa = new HashMap<>();

        List<Produto> produtos = produtoServico.pegarTodos();
        List<Produtor> produtores = produtorServico.pegarTodosProdutores();

        mapa.put("produtos", produtos);
        mapa.put("produtores", produtores);

        return mapa;
    }

    @ResponseBody
    @GetMapping("/produtosDosProdutores")
    public  Map<Produto, List<Produtor>> pegarProdutosDosProduores() {
        List<Produto> produtos = produtoServico.pegarTodos();

        return pedidoServico.pegarProdutoresDosProdutos(produtos);
    }

//    @ResponseBody
//    @GetMapping("/preco-quantidade")
//    public ProdutoProdutor mostraPrecoEQuantidade() {
//        return produtoProdutorServico.pegaPrecoEQuantidade();
//    }

    @ResponseBody
    @GetMapping("/produto-produtor")
    public ProdutoProdutor mostraUmProdutoProdutor() {

        return produtoProdutorServico.encontraUm(1L);
    }


}