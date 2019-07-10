package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.PedidoProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.dominio.excecoes.PedidoNaoSalvoExcecao;
import com.thoughtworks.aceleradora.servicos.EnderecoServico;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.PedidoServico;
import com.thoughtworks.aceleradora.servicos.ProdutoProdutorServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import com.thoughtworks.aceleradora.servicos.ProdutorServico;
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
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private MinhaListaServico minhaListaServico;
    private PedidoServico pedidoServico;
    private EnderecoServico enderecoServico;
    private ProdutorServico produtorServico;
    private ProdutoServico produtoServico;
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

        String nomePedido = pedidoServico.encontraUm(id).getNome();
        modelo.addAttribute("pedido", nomePedido);
        modelo.addAttribute("produtores", pedidoServico.agrupaProdutosPorProdutor(id));

        return "pedido/visualizar-pedido";
    }

    @PostMapping("/{id}/excluir")
    public String removerPedido(@PathVariable("id") Long id, RedirectAttributes redirecionamentoDeAtributos) {

        pedidoServico.removerPedido(id);
        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido excluído com sucesso!");

        return "redirect:/pedidos";
    }

    @GetMapping("/{listaId}/realizar-pedido")
    public String listaProdutoresDeProdutos(Breadcrumb breadcrumb, @PathVariable("listaId") Long listaId, Model modelo,RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Realizar Pedido", "/pedido/pedidos");

        try{
            MinhaLista lista = minhaListaServico.encontraUm(listaId);

            Map<Produto, List<ProdutoProdutor>> produtoresDeProdutos =
                    produtoProdutorServico.pegaProdutoProdutorPorProdutos(lista.getProdutos());

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

    @PostMapping("/realizar-pedido")
    public String salvarPedido(@Valid Pedido pedido, BindingResult resultadoValidacao, Model modelo, RedirectAttributes redirecionamentoDeAtributos,
                               Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Realizar Pedido", "/pedidos");

        try {
            if (resultadoValidacao.hasErrors()) {
                modelo.addAttribute("erros", resultadoValidacao.getAllErrors());
                return "pedido/realizar-pedido";
            }

            pedidoServico.salvarPedido(pedido);

            redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido criado com sucesso");

            return "redirect:/pedidos";
        } catch (PedidoNaoSalvoExcecao | NullPointerException e) {
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());
            return "redirect:/minhas-listas";
        }

    }

    @GetMapping("/{id}/editar-pedido")
    public String editarProdutoPedido(@PathVariable("id") Long id, Breadcrumb breadcrumb, Model modelo) {

        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Editar Pedido", "/editar-pedido");

        Pedido pedido = pedidoServico.encontraUm(id);

        modelo.addAttribute("produtoProdutoresPorProduto", produtoProdutorServico
                .pegaProdutoProdutorPorProdutos(pedido
                        .getPedidosProdutosProdutores()
                        .stream()
                        .map(pedidoProdutoProdutor -> pedidoProdutoProdutor.getProdutoProdutor().getProduto())
                        .collect(Collectors.toList())));
        modelo.addAttribute("produtoProdutoresDoPedido", pedido
                .getPedidosProdutosProdutores()
                .stream()
                .map(PedidoProdutoProdutor::getProdutoProdutor)
                .collect(Collectors.toList()));
        modelo.addAttribute("pedido", pedido);

        return "pedido/editar-pedido";

    }

    @PostMapping("/{id}/editar-pedido")
    public String editarProdutoPedido(Pedido pedido,
                                      Breadcrumb breadcrumb,
                                      Model modelo,
                                      BindingResult resultadoValidacao,
                                      RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Realizar pedido", "/pedidos");

        if(resultadoValidacao.hasErrors()) { // Sem @Valid isso não vai fazer nada.
            modelo.addAttribute("erros", resultadoValidacao.getAllErrors());
            return "/pedidos/editar-pedido";
        }

        pedido.setCriadoEm(pedidoServico.encontraUm(pedido.getId()).getCriadoEm());

        pedidoServico.salvarPedido(pedido);

        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido alterado com sucesso");

        return "redirect:/pedidos";
    }


}