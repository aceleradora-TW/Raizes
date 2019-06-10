package com.thoughtworks.aceleradora.dominio.excecoes;

public class ProdutoNaoSalvoExcecao extends RuntimeException {
    private static final String MENSAGEM = "Produto não cadastrado!";

    public ProdutoNaoSalvoExcecao() {
        super(MENSAGEM);
    }
}
