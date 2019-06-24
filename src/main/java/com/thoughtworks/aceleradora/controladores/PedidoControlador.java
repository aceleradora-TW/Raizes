package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Endereco;
import com.thoughtworks.aceleradora.servicos.EnderecoServico;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.PedidoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private MinhaListaServico minhaListaServico;
    private PedidoServico pedidoServico;
    private EnderecoServico enderecoServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb.pagina("Página Inicial",
            "/");

    @Autowired
    public PedidoControlador(MinhaListaServico minhaListaServico, PedidoServico pedidoServico,
            EnderecoServico enderecoServico) {
        this.minhaListaServico = minhaListaServico;
        this.pedidoServico = pedidoServico;
        this.enderecoServico = enderecoServico;
    }

    @GetMapping
    public String pedidoCriados(Breadcrumb breadcrumb, Model modelo) {
        breadcrumb
        .aproveitar(partesComunsDoBreadCrumb)
        .pagina("Pedidos", "/pedido/pedidos");

        modelo.addAttribute("pedidosCriados", pedidoServico.pegarPedidos());
        return "pedido/pedidos";
    }

    @GetMapping("/{id}/visualizar-pedido")
    public String visualizarPedido(@PathVariable("id") Long id, Model modelo, Breadcrumb breadcrumb) {

        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Visualizar Pedido", "/pedidos");
        return "pedido/visualizar-pedido";
    }

    @GetMapping("/{id}/realizar-pedido")
    public String realizarPedidos(@PathVariable("id") Long id, Breadcrumb breadcrumb) {
        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Realizar Pedido", "/pedido/pedidos");
        return "pedido/realizar-pedido";
    }

    @ResponseBody
    @GetMapping("/enderecos")
    public List<Endereco> mostraEndereco() {
        return enderecoServico.pegaTodos();
    }

    @PostMapping("/{id}/excluir")
    public String removerPedido(@PathVariable("id") Long id, RedirectAttributes redirecionamentoDeAtributos) {

        pedidoServico.removerPedido(id);
        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido excluído com sucesso!");

        return "redirect:/pedidos";
    }









}