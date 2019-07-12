package com.thoughtworks.aceleradora.dominio.excecoes;

public class PedidoSemProdutorExcecao extends NullPointerException {

    public PedidoSemProdutorExcecao() {
        super("Você precisa escolher, pelo menos, um produtor.");
    }

}