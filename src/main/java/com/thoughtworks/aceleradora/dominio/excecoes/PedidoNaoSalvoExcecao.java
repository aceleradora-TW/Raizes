package com.thoughtworks.aceleradora.dominio.excecoes;

public class PedidoNaoSalvoExcecao extends RuntimeException {

    public PedidoNaoSalvoExcecao() {
        super("Pedido não salvo.");
    }
}