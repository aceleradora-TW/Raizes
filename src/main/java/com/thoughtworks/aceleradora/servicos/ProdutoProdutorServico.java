package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio produtoProdutorRepositorio) {
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
    }

    public List<ProdutoresDeProdutos> organizarProdutoresDeProdutos(List<ProdutoProdutor> produtoProdutores) {
        return null;
    }

//    public List<ProdutoProdutor> pegaListadeProdutos(Long id) {
//        MinhaLista lista = minhaListaRepositorio.findById(id).get();
//        List<Produto> produtos = lista.getProdutos();
//
//        return produtoProdutorRepositorio.findByProdutoIn(produtos);
//    }
}
