package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.servicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private MinhaListaServico minhaListaServico;
    private PedidoServico pedidoServico;
    private EnderecoServico enderecoServico;
    private ProdutoServico produtoServico;
    private ProdutorServico produtorServico;
    private ProdutoProdutorServico produtoProdutorServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb.pagina("Página Inicial",
            "/");

    @Autowired
    public PedidoControlador(MinhaListaServico minhaListaServico,
                             PedidoServico pedidoServico,
                             EnderecoServico enderecoServico,
                             ProdutoServico produtoServico,
                             ProdutorServico produtorServico,
                             ProdutoProdutorServico produtoProdutorServico) {
        this.minhaListaServico = minhaListaServico;
        this.pedidoServico = pedidoServico;
        this.enderecoServico = enderecoServico;
        this.produtoServico = produtoServico;
        this.produtorServico = produtorServico;
        this.produtoProdutorServico = produtoProdutorServico;
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


    @GetMapping("/{listaId}/realizar-pedido")
    public String listaProdutoresDeProdutos(Breadcrumb breadcrumb, @PathVariable("listaId") Long listaId, Model modelo) {
        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("realizar pedido", "/pedido/pedidos");

        Map<Produto, List<ProdutoProdutor>> produtoresDeProdutos =
                produtoProdutorServico.organizarProdutosProdutoresDaListadoCliente(listaId);

        modelo.addAttribute("pedido", new Pedido());

        modelo.addAttribute("nomeLista", minhaListaServico.encontraUm(listaId).getNome());

        modelo.addAttribute("produtoresDeProdutos", produtoresDeProdutos);


        return "pedido/realizar-pedido";
    }



    @PostMapping("/{id}/excluir")
    public String removerPedido(@PathVariable("id") Long id, RedirectAttributes redirecionamentoDeAtributos) {


        pedidoServico.removerPedido(id);
        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido excluído com sucesso!");

        return "redirect:/pedidos";
    }


    @PostMapping("/realizar-pedido")
    public String salvarPedido(@Valid Pedido pedido, BindingResult resultadoValidacao, Model modelo, RedirectAttributes redirecionamentoDeAtributos,
                               Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Realizar pedido", "/pedidos");

        if(resultadoValidacao.hasErrors()) {
            modelo.addAttribute("erros", resultadoValidacao.getAllErrors());
            return "pedido/realizar-pedido";
        }

        pedidoServico.salvarPedido(pedido);

        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido criado com sucesso");

        return "redirect:/pedidos";
    }
}