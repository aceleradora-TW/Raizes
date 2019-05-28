package com.thoughtworks.aceleradora.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private ProdutoProdutor produtoProdutor;
    private Integer quantidade;

}
