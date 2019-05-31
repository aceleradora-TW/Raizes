package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private List<Produtor> pegarProdutores() {
        return produtorRepositorio.findAll();

    }

    private List<Produto> pegarProduto() {
        return produtoRepositorio.findAll();

    }
}
