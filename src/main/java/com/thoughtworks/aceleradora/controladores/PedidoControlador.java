package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.servicos.PedidoServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import com.thoughtworks.aceleradora.servicos.ProdutorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página Inicial", "/");

    @Autowired
    public PedidoControlador(ProdutoServico produtoServico,
                             ProdutorServico produtorServico,
                             PedidoServico pedidoServico) {
        this.produtoServico = produtoServico;
        this.produtorServico = produtorServico;
        this.pedidoServico = pedidoServico;
    }



    @GetMapping
    public String pedidos(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedido/pedidos");
        return "/pedido/pedidos";
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
    public List<Produtor> pegarProdutosDosProduores() {
        Produto produto = produtoServico.encontraUm(3L);
        return pedidoServico.procurarProdutores(produto);
    }

}