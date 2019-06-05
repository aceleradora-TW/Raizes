package com.thoughtworks.aceleradora.dominio;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    @OneToOne
    @JoinColumn(name = "id_usuarios")
    private Usuario usuario;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
                ", usuario=" + usuario +
                '}';
    }
}
