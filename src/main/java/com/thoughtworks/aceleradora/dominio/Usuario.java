package com.thoughtworks.aceleradora.dominio;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_de_usuario")
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String senha;
    private String nome;
    private String contato;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_usuario", insertable = false, updatable = false)
    private TipoDeUsuario tipoDeUsuario;

    public Usuario() {
    }

    public Usuario(String email, String senha, String nome, String contato, Endereco endereco) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(contato, usuario.contato) &&
                Objects.equals(endereco, usuario.endereco) &&
                tipoDeUsuario == usuario.tipoDeUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, senha, nome, contato, endereco, tipoDeUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                ", endereco=" + endereco +
                ", tipoDeUsuario=" + tipoDeUsuario +
                '}';
    }
}

