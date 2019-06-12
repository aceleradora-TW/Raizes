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

    @ManyToOne
    @JoinColumn(name = "id_pedidos")
    Pedido pedido;

    public PedidoProdutoProdutor() {
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}