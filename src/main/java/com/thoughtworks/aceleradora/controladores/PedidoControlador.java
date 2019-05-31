package com.thoughtworks.aceleradora.controladores;
import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.servicos.PedidoServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador{
    private PedidoServico pedidoServico;

    public PedidoControlador (PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página Inicial", "/");
    @GetMapping
    public String pedidosCriados(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedido/pedidos");
        modelo.addAttribute("pedidosCriados", pedidoServico.pegarPedidos());
        return "/pedido/pedidos";
    }



    @GetMapping("/realizar-pedido")
    public String realizarPedidos(Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("realizar pedido", "/pedido/pedidos");
        return "pedido/realizar-pedido";
    }



}