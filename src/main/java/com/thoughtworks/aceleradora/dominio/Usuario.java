package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "usuarios")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_usuario")
    private TipoDeUsuario tipoDeUsuario;

    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;

    @OneToOne(mappedBy = "usuario")
    private Produtor produtor;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
}

