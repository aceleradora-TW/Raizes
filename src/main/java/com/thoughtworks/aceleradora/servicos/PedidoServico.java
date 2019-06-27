package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServico {

    private PedidoRepositorio repositorio;

    private ClienteServico clienteServico;


    public PedidoServico(PedidoRepositorio repositorio,
                         ClienteServico clienteServico) {
        this.repositorio = repositorio;
        this.clienteServico = clienteServico;

    }

    public Optional<Pedido> encontraUm(Long id) {
        Optional<Pedido> pedidos = repositorio.findById(id);
        return pedidos;
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

    public Map<Produtor, List<ProdutoProdutor>> agrupaProdutosPorProdutor(Long idPedido){
        Optional<Pedido> pedido = encontraUm(idPedido);

        List<PedidoProdutoProdutor> pedidosProdutosProdutoresDoPedido = pedido.get().getPedidosProdutosProdutores();

        List<ProdutoProdutor> produtoProdutor = new ArrayList<>();

        for (int i = 0; i< pedidosProdutosProdutoresDoPedido.size(); i++) {
            produtoProdutor.add(pedidosProdutosProdutoresDoPedido.get(i).getProdutoProdutor());
        }

        Map<Produtor, List<ProdutoProdutor>> byProdutor
                = produtoProdutor.stream()
                .collect(Collectors.groupingBy(ProdutoProdutor::getProdutor));
        return byProdutor;
    }
}