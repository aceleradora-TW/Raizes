package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PedidoServico {

    private PedidoRepositorio pedidorepositorio;
    private MinhaListaRepositorio minhaListaRepositorio;
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;
    private ClienteServico clienteServico;
    private ProdutoServico produtoServico;
    private ProdutorServico produtorServico;

    public PedidoServico(PedidoRepositorio pedidorepositorio,
                         MinhaListaRepositorio minhaListaRepositorio,
                         ProdutoProdutorRepositorio produtoProdutorRepositorio,
                         ClienteServico clienteServico,
                         ProdutoServico produtoServico,
                         ProdutorServico produtorServico) {
        this.pedidorepositorio = pedidorepositorio;
        this.minhaListaRepositorio = minhaListaRepositorio;
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
        this.clienteServico = clienteServico;
        this.produtoServico = produtoServico;
        this.produtorServico = produtorServico;
    }

    public Pedido encontraUm(Long id) {
        Pedido pedidos = pedidorepositorio.findById(id).get();

        return pedidos;
    }

    public List<Pedido> pegarPedidos() {
        return pedidorepositorio.findAll();
    }

    public List<ProdutoProdutor> pegaListaDeProdutosPorProdutores(Long listaId) {
        Optional<MinhaLista> lista = minhaListaRepositorio.findById(listaId);
        List<Produto> produtos = lista.get().getProdutos();

        return produtoProdutorRepositorio.findByProdutoIn(produtos);
    }

    public void removerPedido(Long idCompra) {
        pedidorepositorio.deleteById(idCompra);
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

        return pedidorepositorio.save(pedido);
    }
}