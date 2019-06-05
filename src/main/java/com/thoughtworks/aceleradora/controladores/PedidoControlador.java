package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.servicos.*;
import com.thoughtworks.aceleradora.dominio.Resposta;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoProdutorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            .pagina("Página Inicial", "/");

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
                .pagina("Compras", "/pedido/pedidos");
        return "pedido/pedidos";
    }

    @GetMapping("/{id}")
    public String visualizarPedido(@PathVariable("id") Long id, Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Visualizar pedido", "/pedidos");

        try {
            modelo.addAttribute("pedido",  minhaListaServico.encontraUm(id));

            return "pedido/visualizar-pedido";
        } catch (ListaNaoEncontradaExcecao e) {
            return "redirect:/pedidos";
        }
    }
    @GetMapping("/realizar-pedido")
    public String realizarPedidos(Breadcrumb breadcrumb, Model modelo) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("realizar pedido", "/pedido/pedidos");
        List<MinhaLista> listaDoBanco = minhaListaServico.encontraUm(id);
        modelo.addAttribute("lista",listaDoBanco);


        ProdutoProdutorServico produtoProdutorServico;
        modelo.addAttribute("produtoProdutores", produtoProdutorServico.pegaTodosProdutoProdutor());
        modelo.addAttribute("pedido", new Pedido());
        return "pedido/realizar-pedido";
    }

    @PostMapping("/realizar")
    public String salvarPedido(Pedido pedido){
        pedidoServico.salvar(pedido);
        return "redirect:/pedidos";
    }

}