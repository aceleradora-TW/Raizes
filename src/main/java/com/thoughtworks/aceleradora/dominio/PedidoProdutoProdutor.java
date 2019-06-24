package com.thoughtworks.aceleradora.dominio;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "pedidos_produtos_produtores")
@Access(AccessType.FIELD)
public class PedidoProdutoProdutor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private int quantidadePedido;

    @ManyToOne
    @JoinColumn(name = "id_produtos_produtores")
    ProdutoProdutor produtoProdutor;

    public PedidoProdutoProdutor() {
    }

    public PedidoProdutoProdutor(int quantidadePedido, ProdutoProdutor produtoProdutor) {
        this.quantidadePedido = quantidadePedido;
        this.produtoProdutor = produtoProdutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidadePedido() {
        return quantidadePedido;
    }

    public void setQuantidadePedido(int quantidadePedido) {
        this.quantidadePedido = quantidadePedido;
    }

    public ProdutoProdutor getProdutoProdutor() {
        return produtoProdutor;
    }

    public void setProdutoProdutor(ProdutoProdutor produtoProdutor) {
        this.produtoProdutor = produtoProdutor;
    }
}