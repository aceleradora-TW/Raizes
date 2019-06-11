package com.thoughtworks.aceleradora.controladores;
import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Endereco;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.servicos.EnderecoServico;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private MinhaListaServico minhaListaServico;
    private EnderecoServico enderecoServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página Inicial", "/");

    @Autowired
    public PedidoControlador(MinhaListaServico minhaListaServico,
                             EnderecoServico enderecoServico) {
        this.minhaListaServico = minhaListaServico;
        this.enderecoServico = enderecoServico;
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
    public String realizarPedidos(Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("realizar pedido", "/pedido/pedidos");

        return "pedido/realizar-pedido";
    }

    @ResponseBody
    @GetMapping("/enderecos")
    public List<Endereco> mostraEndereco() {
        return enderecoServico.pegaTodos();
    }
}