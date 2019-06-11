package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;
    private ProdutorRepositorio produtorRepositorio;
    private ProdutoRepositorio produtoRepositorio;
    private MinhaListaRepositorio minhaListaRepositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio produtoProdutorRepositorio,
                                  ProdutorRepositorio produtorRepositorio,
                                  ProdutoRepositorio produtoRepositorio, MinhaListaRepositorio minhaListaRepositorio) {
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
        this.produtorRepositorio = produtorRepositorio;
        this.produtoRepositorio = produtoRepositorio;
        this.minhaListaRepositorio = minhaListaRepositorio;
    }

    public List<ProdutoProdutor> pegaTodosProdutoProdutor() {
        return produtoProdutorRepositorio.findByProdutoIn(produtoRepositorio.findAll());
    }

    public ProdutoProdutor encontraUm(Long id) {
        Optional<ProdutoProdutor> produtoProdutorOptional = produtoProdutorRepositorio.findById(id);
        produtoProdutorOptional.get().getProduto().getProdutor();


        return produtoProdutorOptional.get();
    }



    public List<ProdutoProdutor> pegaListadeProdutos(Long id) {
        MinhaLista lista = minhaListaRepositorio.findById(id).get();
        List<Produto> produtos = lista.getProdutos();

        return produtoProdutorRepositorio.findByProdutoIn(produtos);
    }
//    public List<ProdutoProdutor> pegaListadeProdutos(Long id){
//        MinhaLista lista = minhaListaRepositorio.findById(id).get();
//
//        List<Produto> listaDeProdutos = lista.getProdutos();
//
//        List<ProdutoProdutor> produtoProdutor = repositorio.findByProdutoIn(produtoRepositorio.findAll());
//
//        List<ProdutoProdutor> listaDeProdutoProdutor = new ArrayList<>();
//
//        for(int i = 0; i < listaDeProdutos.size(); i++) {
//            for(int j = 0; j<produtoProdutor.size(); j++){
//                if (produtoProdutor.get(j).getProduto().getId().equals(lista.getProdutos().get(i).getId())) {
//                    listaDeProdutoProdutor.add(produtoProdutor.get(j));
//                }
//            }
//        }
//        return listaDeProdutoProdutor;
//    }


}
