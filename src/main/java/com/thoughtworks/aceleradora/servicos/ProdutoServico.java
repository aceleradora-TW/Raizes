package com.thoughtworks.aceleradora.servicos;


import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServico {

    private ProdutoRepositorio repositorio;

    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produto> pegarTodosPorOrdemAlfabetica() {
        return repositorio.findAllByOrderByNome();
    }

    public Produto salvar(Produto produto) {
        return repositorio.save(produto);
    }

    public List<Produto> organizarProdutosSemProdutores(MinhaLista lista) {
        List<Produto> produtos = lista.getProdutos();
        return produtos;
    }
    }