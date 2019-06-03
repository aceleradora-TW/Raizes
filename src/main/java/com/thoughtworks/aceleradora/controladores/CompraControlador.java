package com.thoughtworks.aceleradora.controladores;
import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Compras;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.CompraServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.function.Consumer;

@Controller
@RequestMapping("/compras")
public class CompraControlador {

    private MinhaListaServico minhaListaServico;
    private CompraServico compraServico;

    @Autowired
    public CompraControlador (CompraServico compraServico, MinhaListaServico minhaListaServico) {
        this.compraServico = compraServico;
        this.minhaListaServico = minhaListaServico;
    }
    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");


    @GetMapping
    public String comprasFeitas(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Compras", "/pedido/compras");
        modelo.addAttribute("comprasFeitas", compraServico.pegarCompras());
        return "pedido/compras";
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
                .pagina("realizar pedido", "/pedido/pedidos");
        return "pedido/realizar-pedido";
    }

    @PostMapping("/{id}/excluir")
    public String removerCompra(Compras compra, @PathVariable("id") Long id) {
        compraServico.removerCompra(id);
        return "redirect:/compras";
    }


}