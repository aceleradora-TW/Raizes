package com.thoughtworks.aceleradora.login.dominio;

import javax.persistence.*;

@Entity(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sobrenome;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipousuario;

    @Column(unique = true)
    private String email;

    private String telefone;

    public Usuario(){ }

    public Usuario(String nome, String senha, TipoDeUsuario tipousuario, String sobrenome, String email, String telefone) {
        this.nome = nome;
        this.senha = senha;
        this.tipousuario = tipousuario;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoDeUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoDeUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

