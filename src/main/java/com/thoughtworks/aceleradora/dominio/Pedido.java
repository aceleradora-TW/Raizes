package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto_produtores")
    @JsonIgnoreProperties("produtos")
    private ProdutoProdutor produtoProdutor;

    private Integer quantidade;


    public Pedido() {
    }


}
