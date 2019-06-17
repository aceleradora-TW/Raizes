package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtores")
@Access(AccessType.FIELD)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Produtor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    private boolean possuiTransporte;
    private String contato;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "produtos_produtores",
            joinColumns = {@JoinColumn(name = "id_produtores")},
            inverseJoinColumns = {@JoinColumn(name = "id_produtos")}
    )
    @JsonIgnoreProperties("listas")

    private List<Produto> produtos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_enderecos")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Produtor() {
    }

    public Produtor(String nome, boolean possuiTransporte, String contato, List<Produto> produtos, Endereco endereco, Usuario usuario) {
        this.nome = nome;
        this.possuiTransporte = possuiTransporte;
        this.contato = contato;
        this.produtos = produtos;
        this.endereco = endereco;
        this.usuario = usuario;
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

    public boolean isPossuiTransporte() {
        return possuiTransporte;
    }

    public void setPossuiTransporte(boolean possuiTransporte) {
        this.possuiTransporte = possuiTransporte;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Produtor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", possuiTransporte=" + possuiTransporte +
                ", contato='" + contato + '\'' +
                ", produtos=" + produtos +
                ", endereco=" + endereco +
                ", usuario=" + usuario +
                '}';
    }
}

