package com.thoughtworks.aceleradora.dominio.excecoes;

public class ValorProdutoNaoPodeSerNegativoExcecao extends RuntimeException{

    public ValorProdutoNaoPodeSerNegativoExcecao() {
        super("No campo Valor, são aceitos somente valores iguais ou maiores que ZERO.");
    }

}
