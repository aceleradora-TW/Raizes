package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.servicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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
                .pagina("Visualizar Pedido", "/pedidos");

        modelo.addAttribute("lista", lista);
        return "pedido/visualizar-pedido";
    }

    @GetMapping("{id}/realizar")
    public String realizarPedido(@PathVariable("idLista") Long id, Breadcrumb breadcrumb, Model modelo)  {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Realizar Pedido", "/pedidos");

        MinhaLista listaDeProdutos = minhaListaServico.encontraUm(id);

        modelo.addAttribute("listaDeProdutos", listaDeProdutos);

        ProdutoProdutor produtoProdutor = new ProdutoProdutor();


        List<ProdutoProdutor> produtoProdutores = produtoProdutorServico.pegaTodosProdutoProdutor();
//        List<ProdutoProdutor> produtoProdutores = produtoProdutorServico.pegaListadeProdutos();
        modelo.addAttribute("produtoProdutores", produtoProdutores);

        modelo.addAttribute("pedido", new Pedido());

        return "redirect:/pedidos/{id}/realizar/";
    }

    @PostMapping("/realizar")
    public String salvarPedido(Pedido pedido){
        pedidoServico.salvar(pedido);
        return "redirect:/pedidos";
    }

}