package com.thoughtworks.aceleradora.dtos;


import com.thoughtworks.aceleradora.dominio.Produto;

public class ProdutoDTO  extends Produto {
    private boolean checado;


    public ProdutoDTO(Produto produto) {
        super(
                produto.getId().longValue(),
                produto.getNome(),
                produto.getCategoria(),
                produto.getCultivo()
        );
    }

    public boolean isChecado() {
        return checado;
    }

    public void setChecado(boolean checado) {
        this.checado = checado;
    }
}
