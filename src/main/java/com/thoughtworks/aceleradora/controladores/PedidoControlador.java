package com.thoughtworks.aceleradora.controladores;
import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.servicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private ProdutoServico produtoServico;
    private ProdutorServico produtorServico;
    private PedidoServico pedidoServico;
    private MinhaListaServico minhaListaServico;
    private ProdutoProdutorServico produtoProdutorServico;
    private EnderecoServico enderecoServico;


    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página Inicial", "/");

    @Autowired
    public PedidoControlador(ProdutoServico produtoServico,
                             ProdutorServico produtorServico,
                             PedidoServico pedidoServico,
                             MinhaListaServico minhaListaServico,
                            EnderecoServico enderecoServico,
                             ProdutoProdutorServico produtoProdutorServico) {
        this.produtoServico = produtoServico;
        this.produtorServico = produtorServico;
        this.pedidoServico = pedidoServico;
        this.minhaListaServico = minhaListaServico;
        this.produtoProdutorServico = produtoProdutorServico;
        this.enderecoServico=enderecoServico;
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

    @GetMapping("/{id}/realizar-pedido")
    public String realizarPedidos(Breadcrumb breadcrumb, Model modelo, @PathVariable("id") Long id) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("realizar pedido", "/pedido/pedidos");
        MinhaLista listaDoBanco = minhaListaServico.encontraUm(id);

        modelo.addAttribute("produtoProdutores", produtoProdutorServico.pegaListadeProdutos(id));
        return "pedidos/{id}/realizar-pedido";
    }

    @PostMapping("/realizar-pedido")
    public String salvarPedido(Pedido pedido){
        pedidoServico.salvar(pedido);
        return "redirect:/pedidos";
    }
    @ResponseBody
    @GetMapping("/lista-produtores")
    public Map<Produto, List<Produtor>> mostraProdutosComProdutores() {
        List<Produto> produtos = produtoServico.pegarTodos();

        return pedidoServico.pegarProdutoresDosProdutos(produtos);
    }


    @ResponseBody
    @GetMapping("/produto-produtor/{id}")
    public ProdutoProdutor mostraPrecoEQuantidadeDeProdutoDeUmProdutor(Long id) {

        return produtoProdutorServico.encontraUm(id);
    }

    @ResponseBody
    @GetMapping("/produto-produtor")
    public List<ProdutoProdutor> mostraPrecoEQuantidadeDeTodosProdutos() {
        return produtoProdutorServico.pegaTodosProdutoProdutor();
    }



    @ResponseBody
    @GetMapping("/enderecos")
    public List<Endereco> mostraEndereco() {
        return enderecoServico.pegaTodos();
    }
}