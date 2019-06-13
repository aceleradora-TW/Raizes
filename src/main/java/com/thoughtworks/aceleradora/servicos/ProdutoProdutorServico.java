package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoProdutorServico {

    private ProdutoProdutorRepositorio repositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<ProdutoProdutor> PegarTodos(){
        return repositorio.findAll();
    }

    public ProdutoProdutor salvar(ProdutoProdutor produtoProdutor){
        return repositorio.save(produtoProdutor);
    }

    public ProdutoProdutor encontraUm(Long id){
        return repositorio.findById(id).get();
    }
}
