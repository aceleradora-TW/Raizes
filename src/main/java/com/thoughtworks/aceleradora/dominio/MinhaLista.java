package com.thoughtworks.aceleradora.dominio;

import com.thoughtworks.aceleradora.validadores.anotacoes.ListaValida;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "listas")
@ListaValida
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

    private List<Produto> produtos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="id_clientes")
    private Cliente cliente;

    public MinhaLista() {
    }

    public void setId(Long id) {
        this.id = id;

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

    public String getNome() { return nome; }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
