package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.Produtor;

import java.util.ArrayList;
import java.util.List;

public class ProdutoresDeProdutos {

    private Produto produto;
    private List<Produtor> produtores;

    public ProdutoresDeProdutos(Produto produto, Produtor produtor) {
        produtores = new ArrayList<>();
        this.produto = produto;
        produtores.add(produtor);
    }

    public Produto getProduto() {
        return produto;
    }

    public List<Produtor> getProdutores() {
        return produtores;
    }

    public boolean adicionaProdutor(Produtor produtor) {
        return produtores.add(produtor);
    }
}
