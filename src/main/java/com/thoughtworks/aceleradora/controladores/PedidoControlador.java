package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
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

    @GetMapping("/{id}")
    public String visualizarPedido(@PathVariable("id") Long id, Model modelo, Breadcrumb breadcrumb) {

        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Visualizar pedido", "/pedidos");

        try {
            modelo.addAttribute("pedido", minhaListaServico.encontraUm(id));

            return "pedido/visualizar-pedido";
        } catch (ListaNaoEncontradaExcecao e) {
            return "redirect:/pedidos";
        }
    }

    @GetMapping("/{listaId}/realizar-pedido")
    public String realizarPedidos(Breadcrumb breadcrumb, @PathVariable("listaId") Long listaId, Model modelo) {
        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("realizar pedido", "/pedido/pedidos");

        modelo.addAttribute("produtoProdutores" , pedidoServico.pegaListaDeProdutosPorProdutores(listaId));
        modelo.addAttribute("pedido", new Pedido());
        modelo.addAttribute("listaNome", minhaListaServico.encontraUm(listaId).getNome());
        return "pedido/realizar-pedido";
    }


    @ResponseBody
    @GetMapping("/enderecos")
    public List<Endereco> mostraEndereco() {
        return enderecoServico.pegaTodos();
    }

    @PostMapping("/{id}/excluir")
    public String removerPedido(@PathVariable("id") Long id) {
        pedidoServico.removerPedido(id);
        return "redirect:/pedidos";
    }


    @PostMapping("/realizar-pedido")
    public String salvarPedido(@Valid Pedido pedido, BindingResult resultadoValidacao, Model modelo, RedirectAttributes redirecionamentoDeAtributos, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Realizar pedido", "/pedidos");

        if(resultadoValidacao.hasErrors()) {
            modelo.addAttribute("erros", resultadoValidacao.getAllErrors());
//            modelo.addAttribute("")
//            modelo.addAttribute("categorias", categoriaServico.pegarCategorias());

            return "pedido/realizar-pedido";
        }

        pedidoServico.salvarPedido(pedido);

        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido criado com sucesso");

        return "redirect:/pedidos";
    }


    @ResponseBody
    @GetMapping("/teste")
    public Map listaProdutosProdutores(Model modelo) {
        Map<String, List> mapa = new HashMap<>();
        List<Produto> produtos = produtoServico.pegarTodos();
        List<Produtor> produtores = produtorServico.pegarTodosProdutores();
        mapa.put("produtos", produtos);
        mapa.put("produtores", produtores);
        return mapa;
    }

}