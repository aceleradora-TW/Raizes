package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;
    private PedidoServico pedidoServico;
    private MinhaListaServico minhaListaServico;


    public ProdutoProdutorServico(ProdutoProdutorRepositorio produtoProdutorRepositorio, PedidoServico pedidoServico, MinhaListaServico minhalistaServico) {
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
        this.pedidoServico = pedidoServico;
        this.minhaListaServico = minhalistaServico;
    }

    public List<ProdutoProdutor> pegarProdutos(){
        return produtoProdutorRepositorio.findAll();
    }


    public Map<Produto, List<ProdutoProdutor>> organizarProdutosProdutoresDaListadoCliente (MinhaLista lista){

        List<Produto> produtos = lista.getProdutos();

        List<ProdutoProdutor> produtosProdutoresDaLista = produtoProdutorRepositorio.findByProdutoIn(produtos);

        Map<Produto, List<ProdutoProdutor>> byProdProd
                = produtosProdutoresDaLista.stream()
                .collect(Collectors.groupingBy(ProdutoProdutor::getProduto));

        return byProdProd;
    }


    public ProdutoProdutor encontraUm(Long id) {
        return produtoProdutorRepositorio
                .findById(id)
                .orElseThrow(ProdutoNaoEncontradoExcecao::new);

    }

    public ProdutoProdutor salvar(ProdutoProdutor produtoProdutor) {
        return produtoProdutorRepositorio.save(produtoProdutor);
    }
}
