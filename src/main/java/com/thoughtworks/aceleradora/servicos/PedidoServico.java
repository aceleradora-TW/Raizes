package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.List;

@Service
public class PedidoServico {

    private PedidoRepositorio pedidorepositorio;
    private MinhaListaRepositorio minhaListaRepositorio;
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;

    public PedidoServico(PedidoRepositorio repositorio) {
        this.pedidorepositorio = repositorio;
    }

    public Pedido encontraUm(Long id) {
        Pedido pedidos = pedidorepositorio.findById(id).get();

        return pedidos;
    }

    public List<Pedido> ordenaPedido(List<Pedido> pedidos){
        List<Pedido> pedidosOrdenadas;

//        for (pedido: pedidos) {
//
//        }

        return null;
    }

    public List<ProdutoProdutor> pegaListaDeProdutosPorProdutores(String listaId) {
        MinhaLista lista = minhaListaRepositorio.findById(listaId).get();
        List<Produto> produtos = lista.getProdutos();

        return produtoProdutorRepositorio.findByProdutoIn(produtos);
    }
}