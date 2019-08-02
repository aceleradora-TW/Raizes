package com.thoughtworks.aceleradora.dominio;

import com.thoughtworks.aceleradora.validadores.anotacoes.RealizarPedidoValida;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "pedidos_produtos_produtores")
@Access(AccessType.FIELD)
@RealizarPedidoValida
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

    private BigDecimal valor;

    public PedidoProdutoProdutor() {
    }

    public PedidoProdutoProdutor(int quantidadePedido, ProdutoProdutor produtoProdutor, BigDecimal valor) {
        this.quantidadePedido = quantidadePedido;
        this.produtoProdutor = produtoProdutor;
        this.valor = valor;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
