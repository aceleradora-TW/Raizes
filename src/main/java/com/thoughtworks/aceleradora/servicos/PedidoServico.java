package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.*;
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
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;


    public PedidoServico(PedidoRepositorio repositorio,
                         ProdutoProdutorRepositorio produtoProdutorRepositorio) {
        this.repositorio = repositorio;
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
    }

    public List<Pedido> pegarPedidos() {
        return repositorio.findAll();
    }

    public Optional<Pedido> encontraUm(Long id) {
        Optional<Pedido> pedidos = repositorio.findById(id);

        return pedidos;
    }


    public Map<Produtor, List<ProdutoProdutor>> organizaProdutosPorProdutor(Long idPedido){
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

    public void removerPedido(Long idCompra) {
        repositorio.deleteById(idCompra);
    }

}
