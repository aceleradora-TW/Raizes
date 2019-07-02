package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "pedidos")
@Access(AccessType.FIELD)
public class Pedido {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp criadoEm;

    @ManyToOne
    @JoinColumn(name = "id_clientes")
    Cliente cliente;

    @JsonIgnoreProperties("pedido")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pedidos")
    private List<PedidoProdutoProdutor> pedidosProdutosProdutores;


    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Timestamp getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Timestamp criadoEm) {
        this.criadoEm = criadoEm;
    }

    public List<PedidoProdutoProdutor> getPedidosProdutosProdutores() {
        return pedidosProdutosProdutores;
    }

    public void setPedidosProdutosProdutores(List<PedidoProdutoProdutor> pedidosProdutosProdutores) {
        this.pedidosProdutosProdutores = pedidosProdutosProdutores;
    }
}
