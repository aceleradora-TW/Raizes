package com.thoughtworks.aceleradora.dominio.excecoes;

public class ProdutoNaoEncontradoExcecao extends RuntimeException {

    public ProdutoNaoEncontradoExcecao () {
        super("Produto não encontrado!");
    }

}
