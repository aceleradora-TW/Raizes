package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ClienteRepositorio;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServico {

    private PedidoRepositorio pedidorepositorio;
    private MinhaListaRepositorio minhaListaRepositorio;
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;
    private ClienteServico clienteServico;

    public PedidoServico(PedidoRepositorio pedidorepositorio,
                         MinhaListaRepositorio minhaListaRepositorio,
                         ProdutoProdutorRepositorio produtoProdutorRepositorio,
                         ClienteServico clienteServico) {
        this.pedidorepositorio = pedidorepositorio;
        this.minhaListaRepositorio = minhaListaRepositorio;
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
        this.clienteServico = clienteServico;
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
        pedido.setCliente(clienteServico.encontraNeiva());
        return pedidorepositorio.save(pedido);
    }
}




