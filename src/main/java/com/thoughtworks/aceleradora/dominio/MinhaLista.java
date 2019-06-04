package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "listas")
public class MinhaLista {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "listas_produtos",
            joinColumns = {@JoinColumn(name = "id_lista")},
            inverseJoinColumns = {@JoinColumn(name = "id_produtos")}
    )
    @JsonIgnoreProperties("listas")
    private List<Produto> produtos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_clientes")
    private Cliente cliente;

    public MinhaLista() {

    }

    public MinhaLista(String nome) {
        this.nome = nome;

    }

    public void setId(Long id) {
        this.id = id;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }


}
