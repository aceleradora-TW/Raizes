package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProdutoresDeProdutos {

    private Produto produto;
    private List<Produtor> produtores = new ArrayList<>();
    private List<ProdutoProdutor> produtoProdutores = new ArrayList<>();

    public ProdutoresDeProdutos(Produto produto, List<ProdutoProdutor> produtoProdutores) {
        this.produto = produto;
        this.produtoProdutores = produtoProdutores;
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
        return produtoProdutores;
    }

    public void setProdutosProdutores(List<ProdutoProdutor> produtosProdutores) {
        this.produtoProdutores = produtosProdutores;
    }

    public List<Produtor> getProdutores() {
        return produtores;
    }

    public boolean adicionaProdutor(Produtor produtor) {
        return produtores.add(produtor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoresDeProdutos that = (ProdutoresDeProdutos) o;
        return Objects.equals(produto, that.produto) &&
                Objects.equals(produtores, that.produtores) &&
                Objects.equals(produtoProdutores, that.produtoProdutores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, produtores, produtoProdutores);
    }

    @Override
    public String toString() {
        return "ProdutoresDeProdutos{" +
                "produto=" + produto +
                ", produtores=" + produtores +
                ", produtoProdutores=" + produtoProdutores +
                '}';
    }
}
