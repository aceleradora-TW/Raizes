package com.thoughtworks.aceleradora.dominio.excecoes;

public class ListaNaoEncontradaExcecao extends RuntimeException {
    private static final String MENSAGEM = "Lista não encontrada!";

    public ListaNaoEncontradaExcecao() {
        super(MENSAGEM);
    }
}
