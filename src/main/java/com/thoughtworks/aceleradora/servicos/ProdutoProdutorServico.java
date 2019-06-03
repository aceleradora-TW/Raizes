package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio repositorio;
    private ProdutorRepositorio produtorRepositorio;
    private ProdutoRepositorio produtoRepositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio repositorio,
                                  ProdutorRepositorio produtorRepositorio,
                                  ProdutoRepositorio produtoRepositorio) {
        this.repositorio = repositorio;
        this.produtorRepositorio = produtorRepositorio;
        this.produtoRepositorio = produtoRepositorio;
    }

    public List<ProdutoProdutor> pegaTodosProdutoProdutor() {
        return repositorio.findAll();

    }

    public ProdutoProdutor encontraUm(Long id) {
        Optional<ProdutoProdutor> produtoProdutorOptional = repositorio.findById(id);
        return produtoProdutorOptional.get();
    }


}
