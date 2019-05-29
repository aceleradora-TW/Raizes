package com.thoughtworks.aceleradora.dominio;


public class ProdutoDTO extends Produto{
    private boolean checado;

    public ProdutoDTO(){

    }

    public ProdutoDTO(String nome, boolean checado) {
        this.checado = checado;
    }

    public boolean isChecado() {
        return checado;
    }

    public void setChecado(boolean checado) {
        this.checado = checado;
    }
}
