package com.thoughtworks.aceleradora.dominio;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    private String contato;

    @OneToMany(mappedBy="cliente")
    private List<MinhaLista> minhasListas;

    @ManyToOne
    @JoinColumn(name = "id_usuarios")
    private Usuario usuario;

    public Cliente() {
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public List<MinhaLista> getMinhasListas() {
        return minhasListas;
    }

    public void setMinhasListas(List<MinhaLista> minhasListas) {
        this.minhasListas = minhasListas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                ", minhasListas=" + minhasListas +
                ", usuario=" + usuario +
                '}';
    }

}
