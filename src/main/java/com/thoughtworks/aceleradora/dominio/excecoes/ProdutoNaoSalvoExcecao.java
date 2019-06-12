package com.thoughtworks.aceleradora.dominio.excecoes;

public class ProdutoNaoSalvoExcecao extends RuntimeException {

    public ProdutoNaoSalvoExcecao() {
        super("Produto não cadastrado!");
    }
}