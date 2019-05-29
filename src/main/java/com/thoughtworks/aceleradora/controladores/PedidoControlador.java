package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private MinhaListaServico minhaListaServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");

    @Autowired
    public PedidoControlador(MinhaListaServico minhaListaServico) {
        this.minhaListaServico = minhaListaServico;
    }

    @GetMapping
    public String pedidos(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedido/pedidos");
        return "/pedido/pedidos";
    }

    @GetMapping("/{id}/visualizar")
    public String visualizarPedido( @PathVariable("id") Long id, Model modelo, Breadcrumb breadcrumb) {
        MinhaLista lista = minhaListaServico.encontraUm(id);
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Visualizar pedido", "/pedidos/visualizar");

        modelo.addAttribute("lista", lista);
        return "pedido/visualizar-pedido";
    }

    @PostMapping("/{id}/visualizar")
    public String visualizarPedido(MinhaLista minhaLista, @PathVariable("id") Long id, Breadcrumb breadcrumb) {
        MinhaLista lista = minhaListaServico.encontraUm(id);
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Visualizar pedido", "/pedidos/visualizar");

        lista.setNome(minhaLista.getNome());
        return "pedido/visualizar-pedido";
    }
}