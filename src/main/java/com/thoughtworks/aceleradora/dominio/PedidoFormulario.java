package com.thoughtworks.aceleradora.dominio;

import java.util.List;

public class PedidoFormulario {

    private List<ProdutoProdutor> listaProdutoProdutor;
    private List<Integer> quantidade;
    private String nomePedido;

    public PedidoFormulario(List<ProdutoProdutor> listaProdutoProdutor, List<Integer> quantidade, String nomePedido) {
        this.listaProdutoProdutor = listaProdutoProdutor;
        this.quantidade = quantidade;
        this.nomePedido = nomePedido;
    }

    public List<ProdutoProdutor> getListaProdutoProdutor() {
        return listaProdutoProdutor;
    }

    public void setListaProdutoProdutor(List<ProdutoProdutor> listaProdutoProdutor) {
        this.listaProdutoProdutor = listaProdutoProdutor;
    }

    public List<Integer> getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(List<Integer> quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }
}
