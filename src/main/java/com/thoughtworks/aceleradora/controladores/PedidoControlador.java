package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.componentes.EmailComponente;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
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
    private ProdutorServico produtorServico;
    private ProdutoServico produtoServico;
    private ProdutoProdutorServico produtoProdutorServico;
    private EmailComponente emailComponente;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb.pagina("Página Inicial",
            "/");

    @Autowired
    public PedidoControlador(MinhaListaServico minhaListaServico,
                             PedidoServico pedidoServico,
                             EnderecoServico enderecoServico,
                             ProdutorServico produtorServico,
                             ProdutoServico produtoServico,
                             ProdutoProdutorServico produtoProdutorServico,
                             EmailComponente emailComponente) {
        this.minhaListaServico = minhaListaServico;
        this.pedidoServico = pedidoServico;
        this.enderecoServico = enderecoServico;
        this.produtorServico = produtorServico;
        this.produtoServico = produtoServico;
        this.produtoProdutorServico = produtoProdutorServico;
        this.emailComponente = emailComponente;
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

        String nomePedido = pedidoServico.encontraUm(id).get().getNome();
        modelo.addAttribute("pedido", nomePedido);
        modelo.addAttribute("produtores", pedidoServico.agrupaProdutosPorProdutor(id));

        return "pedido/visualizar-pedido";
    }

    @GetMapping("/{listaId}/realizar-pedido")
    public String listaProdutoresDeProdutos(Breadcrumb breadcrumb, @PathVariable("listaId") Long listaId, Model modelo,RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Realizar Pedido", "/pedido/pedidos");

        try{
            MinhaLista lista = minhaListaServico.encontraUm(listaId);

            Map<Produto, List<ProdutoProdutor>> produtoresDeProdutos =
                    produtoProdutorServico.organizarProdutosProdutoresDaListadoCliente(lista);

            modelo.addAttribute("produtos", lista.getProdutos());
            modelo.addAttribute("pedido", new Pedido());

            modelo.addAttribute("nomeLista", lista.getNome());

            modelo.addAttribute("produtoresDeProdutos", produtoresDeProdutos);

            return "pedido/realizar-pedido";
        }catch (ListaNaoEncontradaExcecao e){
            redirecionamentoDeAtributos.addFlashAttribute("mensagem",e.getMessage());

            return "redirect:/minhas-listas/";
        }

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
                .pagina("Realizar Pedido", "/pedidos");

        if(resultadoValidacao.hasErrors()) {
            modelo.addAttribute("erros", resultadoValidacao.getAllErrors());
            return "pedido/realizar-pedido";
        }

        pedidoServico.salvarPedido(pedido);
        emailComponente.notificaProdutor(pedido);
        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido criado com sucesso");

        return "redirect:/pedidos";
    }

    @GetMapping("/editar-pedido")
    public String editarProdutoPedido(Breadcrumb breadcrumb) {

        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Editar Pedido", "/editar-pedido");

        return "pedido/editar-pedido";

    }
}
