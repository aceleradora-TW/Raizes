package com.thoughtworks.aceleradora.controladores;
import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.servicos.PedidoServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador{
    PedidoServico pedidoServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página Inicial", "/");

    @GetMapping("/listar")
    public String pedidos(Model modelo, @PathVariable("id") Long id, Breadcrumb breadcrumb) {
        Pedido pedido = pedidoServico.encontraUm(id);
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/Pedido/pedidos");
        modelo.addAttribute("pedidos", pedido);
        return "/Pedido/pedidos";
    }
    @PostMapping("/listar")
    public String pedidosListar(MinhaLista nomeLista, @PathVariable("id") Long id, Breadcrumb breadcrumb) {
        Pedido pedido = pedidoServico.encontraUm(id);
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/Pedido/pedidos");
        pedido.setNome(nomeLista.getNome());
        pedidoServico.salvar(pedido);
        return "/Pedido/pedidos";
    }

    @GetMapping("/realizar-pedido")
    public String realizarPedidos(Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("realizar Pedido", "/Pedido/pedidos");
        return "pedido/realizar-pedido";
    }



}