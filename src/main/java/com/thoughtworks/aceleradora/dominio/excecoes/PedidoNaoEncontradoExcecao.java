package com.thoughtworks.aceleradora.dominio.excecoes;

public class PedidoNaoEncontradoExcecao extends RuntimeException{

    public PedidoNaoEncontradoExcecao() {
        super("Pedido não encontrado");
    }

}
