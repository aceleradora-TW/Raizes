package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.PedidoProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.dominio.excecoes.PedidoNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PedidoServico {

    private PedidoRepositorio repositorio;

    private ClienteServico clienteServico;

    public PedidoServico(PedidoRepositorio repositorio, ClienteServico clienteServico) {
        this.repositorio = repositorio;
        this.clienteServico = clienteServico;
    }

    public Pedido encontraUm(Long id) {
        return repositorio.findById(id)
                .orElseThrow(PedidoNaoEncontradoExcecao::new);
    }

    public List<Pedido> pegarPedidos() {
        return repositorio.findAll();
    }

    public void removerPedido(Long idCompra) {
        repositorio.deleteById(idCompra);
    }

    public Pedido salvarPedido(Pedido pedido) {
        pedido.setCliente(clienteServico.encontraCliente());

        pedido.setPedidosProdutosProdutores(pedido
                .getPedidosProdutosProdutores()
                .stream()
                .filter(pedidoProdutoProdutor -> pedidoProdutoProdutor.getProdutoProdutor() != null)
                .peek(pedidoProdutoProdutor -> pedidoProdutoProdutor.setValor(pedidoProdutoProdutor
                        .getProdutoProdutor().getPreco()))
                .collect(Collectors.toList())
        );
        return repositorio.save(pedido);
    }

    public Map<Produtor, List<ProdutoProdutor>> agrupaProdutosPorProdutor(Long idPedido) {
        Pedido pedido = encontraUm(idPedido);

        List<PedidoProdutoProdutor> pedidosProdutosProdutoresDoPedido = pedido.getPedidosProdutosProdutores();

        List<ProdutoProdutor> produtoProdutor = new ArrayList<>();

        for (int i = 0; i < pedidosProdutosProdutoresDoPedido.size(); i++) {
            produtoProdutor.add(pedidosProdutosProdutoresDoPedido.get(i).getProdutoProdutor());
        }

        Map<Produtor, List<ProdutoProdutor>> byProdutor
                = produtoProdutor.stream()
                .collect(Collectors.groupingBy(ProdutoProdutor::getProdutor));
        return byProdutor;
    }

    public BigDecimal calculaTotalDoProduto (PedidoProdutoProdutor pedidoProdutoProdutor){

        BigDecimal quantidade = new BigDecimal(pedidoProdutoProdutor.getQuantidadePedido());

        return pedidoProdutoProdutor.getValor().multiply(quantidade);
    }

//    public HashMap calculaTotalPorProduto(List<PedidoProdutoProdutor> pedidoProdutoProdutores) {
//        HashMap listaTotalPorProduto = new HashMap();
//
//        BigDecimal precoCadaProduto;
//
//        for (PedidoProdutoProdutor pedido : pedidoProdutoProdutores) {
//            precoCadaProduto = calculaTotalDoProduto(pedido);
//            listaTotalPorProduto.put(pedido.getId(), precoCadaProduto);
//        }
//
//        return listaTotalPorProduto;
//    }
//
//    public HashMap calculaTotalPedido(HashMap listaTotalPorProduto, List<PedidoProdutoProdutor> pedidoProdutoProdutores) {
//        BigDecimal totalPedido = new BigDecimal(0);
//        BigDecimal aux = new BigDecimal(0);
//
//        for (PedidoProdutoProdutor pedido : pedidoProdutoProdutores.pr) {
//            totalProduto = new BigDecimal(listaTotalPorProduto.get(pedido.getId()).toString());
//            totalPedido = totalPedido.add(precoCadaProduto);
//
//        }
//
//
//
//    }
}