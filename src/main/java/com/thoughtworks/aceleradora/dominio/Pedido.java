package com.thoughtworks.aceleradora.dominio;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="pedidos")
public class Pedido {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private int quantidadePedido;

    @ManyToOne
    @JoinColumn(name = "id_compras" )
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_produto_produtor" )
    private Compra produtoProdutor;

    public Pedido() {

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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
