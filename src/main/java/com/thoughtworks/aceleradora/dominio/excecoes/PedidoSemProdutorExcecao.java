package com.thoughtworks.aceleradora.dominio.excecoes;

public class PedidoSemProdutorExcecao extends NullPointerException {

    public PedidoSemProdutorExcecao() {
        super("Pedido não salvo.");
    }
}