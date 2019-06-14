package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;

import java.util.ArrayList;
import java.util.List;

public class ProdutoresDeProdutos {

    private Produto produto;
    private List<Produtor> produtores;
    private List<ProdutoProdutor> produtosProdutores;

    public ProdutoresDeProdutos(Produto produto, Produtor produtor) {
        produtores = new ArrayList<>();
        this.produto = produto;
        produtores.add(produtor);
    }


    public ProdutoresDeProdutos(Produto produto, Produtor produtor, ProdutoProdutor produtoProdutor) {
        produtores = new ArrayList<>();
        produtosProdutores = new ArrayList<>();
        this.produto = produto;
        produtores.add(produtor);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setProdutores(List<Produtor> produtores) {
        this.produtores = produtores;
    }

    public List<ProdutoProdutor> getProdutosProdutores() {
        return produtosProdutores;
    }

    public void setProdutosProdutores(List<ProdutoProdutor> produtosProdutores) {
        this.produtosProdutores = produtosProdutores;
    }

    public List<Produtor> getProdutores() {
        return produtores;
    }

    public boolean adicionaProdutor(Produtor produtor) {
        return produtores.add(produtor);
    }
}
