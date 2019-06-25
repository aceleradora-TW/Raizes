package com.thoughtworks.aceleradora.dominio.excecoes;

public class QuantidadeProdutoDeveSerNaturalExcecao extends RuntimeException{

    public QuantidadeProdutoDeveSerNaturalExcecao() {
        super("No campo Quantidade, são aceitos somente valores NATURAIS.");
    }

}
