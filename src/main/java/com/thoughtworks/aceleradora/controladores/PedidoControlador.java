package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.componentes.EmailComponente;
import com.thoughtworks.aceleradora.dominio.excecoes.PedidoNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.dominio.excecoes.PedidoNaoSalvoExcecao;
import com.thoughtworks.aceleradora.dominio.excecoes.PedidoSemProdutorExcecao;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.PedidoServico;
import com.thoughtworks.aceleradora.servicos.ProdutoProdutorServico;
import com.thoughtworks.aceleradora.servicos.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    private MinhaListaServico minhaListaServico;
    private PedidoServico pedidoServico;
    private ProdutoProdutorServico produtoProdutorServico;
    private EmailComponente emailComponente;
    private UserDetailsImpl usuarioServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb.pagina("Página Inicial",
            "/");

    @Autowired
    public PedidoControlador(MinhaListaServico minhaListaServico, PedidoServico pedidoServico, ProdutoProdutorServico produtoProdutorServico,
                             EmailComponente emailComponente, UserDetailsImpl usuarioServico) {
        this.minhaListaServico = minhaListaServico;
        this.pedidoServico = pedidoServico;
        this.produtoProdutorServico = produtoProdutorServico;
        this.emailComponente = emailComponente;
        this.usuarioServico = usuarioServico;
    }

    @GetMapping
    public String pedidoCriados(Breadcrumb breadcrumb,
                                Model modelo) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedido/pedidos");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Usuario usuario = usuarioServico.buscaUmUsuario(auth.getName());

        modelo.addAttribute("pedidosCriados", pedidoServico.pegarPedidosPorId(usuario.getId()));
        return "pedido/pedidos";
    }

    @GetMapping("/{id}/visualizar-pedido")
    public String visualizarPedido(@PathVariable("id") Long id,
                                   Model modelo,
                                   Breadcrumb breadcrumb) {

        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Visualizar Pedido", "/pedidos");

        String nomePedido = pedidoServico.encontraUm(id).getNome();
        List<PedidoProdutoProdutor> pedidoProdutoProdutores = pedidoServico.encontraUm(id).getPedidosProdutosProdutores();

        HashMap listaTotalPorProduto = new HashMap();

        HashMap listaTotalPorProdutor = new HashMap();


        BigDecimal totalPedido = new BigDecimal(0);
        BigDecimal precoCadaProduto;
        BigDecimal totalProdutor = new BigDecimal(0);
        for (PedidoProdutoProdutor pedido : pedidoProdutoProdutores) {
            precoCadaProduto = pedidoServico.calculaTotalDoProduto(pedido);
            listaTotalPorProduto.put(pedido.getId(), precoCadaProduto);
            totalPedido = totalPedido.add(precoCadaProduto);

            if (listaTotalPorProdutor.containsKey(pedido.getProdutoProdutor().getProdutor().getId())) {

                totalProdutor = new BigDecimal(listaTotalPorProdutor.get(pedido.getProdutoProdutor().getProdutor().getId()).toString());

                totalProdutor = totalProdutor.add(precoCadaProduto);

                listaTotalPorProdutor.put(pedido.getProdutoProdutor().getProdutor().getId(), totalProdutor);

            } else {
                listaTotalPorProdutor.put(pedido.getProdutoProdutor().getProdutor().getId(), precoCadaProduto);
            }
        }

        modelo.addAttribute("pedido", nomePedido);
        modelo.addAttribute("produtores", pedidoServico.agrupaProdutosPorProdutor(id));
        modelo.addAttribute("pedidoProdutoProdutores", pedidoProdutoProdutores);
        modelo.addAttribute("precoProduto", listaTotalPorProduto);
        modelo.addAttribute("totalPedido", totalPedido);
        modelo.addAttribute("totalProdutor", listaTotalPorProdutor);


        return "pedido/visualizar-pedido";
    }

    @PostMapping("/{id}/excluir")
    public String removerPedido(@PathVariable("id") Long id, RedirectAttributes redirecionamentoDeAtributos) {

        pedidoServico.removerPedido(id);
        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido excluído com sucesso!");

        return "redirect:/pedidos";
    }

    @GetMapping("/{listaId}/realizar-pedido")
    public String listaProdutoresDeProdutos(Breadcrumb breadcrumb,
                                            @PathVariable("listaId") Long listaId,
                                            Model modelo,
                                            RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Realizar Pedido", "/pedido/pedidos");

        try {
            MinhaLista lista = minhaListaServico.encontraUm(listaId);
            Map<Produto, List<ProdutoProdutor>> produtoresDeProdutos = produtoProdutorServico.pegaProdutoProdutorPorProdutos(lista.getProdutos());

           boolean hasProdutor = produtoProdutorServico.hasProdutor(produtoresDeProdutos);

            modelo.addAttribute("produtos", lista.getProdutos());
            modelo.addAttribute("pedido",  new Pedido());
            modelo.addAttribute("nomeLista", lista.getNome());
            modelo.addAttribute("produtoresDeProdutos", produtoresDeProdutos);
            modelo.addAttribute("hasProdutor", hasProdutor);

            return "pedido/realizar-pedido";
        } catch (PedidoNaoEncontradoExcecao e) {
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());

            return "redirect:/minhas-listas/";
        }
    }

    @PostMapping("/realizar-pedido")
    public String salvarPedido(@Valid Pedido pedido,
                               BindingResult resultadoValidacao,
                               RedirectAttributes redirecionamentoDeAtributos,
                               Breadcrumb breadcrumb,
                               HttpServletRequest request) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Realizar Pedido", "/pedidos");

        try {

            if (resultadoValidacao.hasErrors()) {
                redirecionamentoDeAtributos.addFlashAttribute("erros", resultadoValidacao.getAllErrors());

                String paginaAtual = request.getHeader("Referer");

                return "redirect:" + paginaAtual;
            }

            Pedido pedidoSalvo = pedidoServico.salvarPedido(pedido);
            emailComponente.notificaProdutor(pedidoSalvo);

            redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido criado com sucesso");

            return "redirect:/pedidos";
        } catch (PedidoNaoSalvoExcecao | PedidoSemProdutorExcecao e) {
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());
            return "redirect:/minhas-listas";
        }
    }


    @GetMapping("/{id}/editar-pedido")
    public String editarProdutoPedido(@PathVariable("id") Long id, Breadcrumb breadcrumb, Model modelo, RedirectAttributes redirecionamentoDeAtributos) {

        breadcrumb.aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Editar Pedido", "/editar-pedido");
        try {
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
        } catch (PedidoNaoEncontradoExcecao e) {
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());
            return "redirect:/pedidos";

        }
    }

    @PostMapping("/{id}/editar-pedido")
    public String editarProdutoPedido(@Valid Pedido pedido,
                                      BindingResult resultadoValidacao,
                                      RedirectAttributes redirecionamentoDeAtributos,
                                      Breadcrumb breadcrumb,
                                      HttpServletRequest request) {

        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Pedidos", "/pedidos")
                .pagina("Editar pedido", "/pedidos");

        try {
            pedido.setCriadoEm(pedidoServico.encontraUm(pedido.getId()).getCriadoEm());

            if (resultadoValidacao.hasErrors()) {
                redirecionamentoDeAtributos.addFlashAttribute("erros", resultadoValidacao.getAllErrors());

                String paginaAtual = request.getHeader("Referer");
                return "redirect:" + paginaAtual;
            }
            pedidoServico.salvarPedido(pedido);

            redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Pedido alterado com sucesso");

            return "redirect:/pedidos";
        } catch (PedidoNaoSalvoExcecao | PedidoSemProdutorExcecao e) {
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());
            return "/pedidos";
        }
    }

}