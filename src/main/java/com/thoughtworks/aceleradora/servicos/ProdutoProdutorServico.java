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
    private ProdutoProdutorRepositorio repositorio;
    private ProdutorRepositorio produtorRepositorio;
    private ProdutoRepositorio produtoRepositorio;
    private MinhaListaRepositorio minhaListaRepositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio repositorio,
                                  ProdutorRepositorio produtorRepositorio,
                                  ProdutoRepositorio produtoRepositorio, MinhaListaRepositorio minhaListaRepositorio) {
        this.repositorio = repositorio;
        this.produtorRepositorio = produtorRepositorio;
        this.produtoRepositorio = produtoRepositorio;
        this.minhaListaRepositorio = minhaListaRepositorio;
    }

    public List<ProdutoProdutor> pegaTodosProdutoProdutor() {
        return repositorio.findAll();

    }

    public ProdutoProdutor encontraUm(Long id) {
        Optional<ProdutoProdutor> produtoProdutorOptional = repositorio.findById(id);
        return produtoProdutorOptional.get();
    }

//    public List<ProdutoProdutor> pegaListadeProdutos(Long id){
//        MinhaLista lista = minhaListaRepositorio.findById(id).get();
//        List<Produto> listaDeProdutos= lista.getProdutos();
//        ProdutoProdutor produtoProdutor = new ProdutoProdutor();
//        List<ProdutoProdutor> listaDeProdutoProdutor = new ArrayList<ProdutoProdutor>();
//
//        for(int i = 0; i < lista.getProdutos().size(); i++) {
//            if (produtoProdutor.getProduto().getId().equals(lista.getProdutos().get(i).getId())) {
//
//
//                listaDeProdutoProdutor.add(produtoProdutor.getProduto(). getId(id));
//            }
//        }
//
//
//        return listaDeProdutoProdutor;
//    }


}
