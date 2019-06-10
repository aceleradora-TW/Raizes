package com.thoughtworks.aceleradora.controladores;
import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.PedidoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private MinhaListaServico minhaListaServico;
    private PedidoServico pedidoServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página Inicial", "/");

    @Autowired
    public PedidoControlador(MinhaListaServico minhaListaServico, PedidoServico pedidoServico) {
        this.minhaListaServico = minhaListaServico;
        this.pedidoServico = pedidoServico;
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
            modelo.addAttribute("pedido",  pedidoServico.encontraUm(id));
            return "pedido/visualizar-pedido";

        } catch (ListaNaoEncontradaExcecao e) {
            return "redirect:/pedidos";
        }

    }
    @GetMapping("/realizar-pedido")
    public String realizarPedidos(Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("realizar pedido", "/pedido/pedidos");

        return "pedido/realizar-pedido";
    }
}