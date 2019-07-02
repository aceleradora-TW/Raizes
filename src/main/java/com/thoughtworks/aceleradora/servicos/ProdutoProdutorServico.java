package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;


    public ProdutoProdutorServico(ProdutoProdutorRepositorio produtoProdutorRepositorio) {
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
    }

    public List<ProdutoProdutor> pegarProdutos() {
        return produtoProdutorRepositorio.findAll();
    }


    public Map<Produto, List<ProdutoProdutor>> organizarProdutosProdutoresDaListadoCliente(MinhaLista lista) {

        List<Produto> produtos = lista.getProdutos();

        List<ProdutoProdutor> produtosProdutoresDaLista = produtoProdutorRepositorio.findByProdutoIn(produtos);

        Map<Produto, List<ProdutoProdutor>> byProdProd
                = produtosProdutoresDaLista.stream()
                .collect(Collectors.groupingBy(ProdutoProdutor::getProduto));

        return byProdProd;
    }

//    public Map<Produto, List<ProdutoProdutor>> organizaEditarPedido(Optional<Pedido> pedido) {
//
//        List<PedidoProdutoProdutor> pedidoProdutoProdutores = pedido.get().getPedidosProdutosProdutores();
//        List<ProdutoProdutor> produtoProdutorDoPedido = new ArrayList<>();
//        for (int i = 0; i< pedidoProdutoProdutores.size(); i++) {
//            produtoProdutorDoPedido.add(produtoProdutorRepositorio.get(i).getProduto());
//
//        }
//
//        List<ProdutoProdutor> produtoProdutor = new ArrayList<>();
//
//        for (int i = 0; i < pedidoProdutoProdutores.size(); i++) {
//            produtoProdutor.add(pedidoProdutoProdutores.get(i).getProdutoProdutor());
//        }
//
//        Map<Produto, List<ProdutoProdutor>> produtoPorProdutor
//                = produtoProdutor.stream()
//                .collect(Collectors.groupingBy(ProdutoProdutor::getProduto));
//
//        return produtoPorProdutor;
//    }




    public ProdutoProdutor encontraUm(Long id) {
        return produtoProdutorRepositorio
                .findById(id)
                .orElseThrow(ProdutoNaoEncontradoExcecao::new);

    }

    public ProdutoProdutor salvar(ProdutoProdutor produtoProdutor) {
        return produtoProdutorRepositorio.save(produtoProdutor);
    }
}