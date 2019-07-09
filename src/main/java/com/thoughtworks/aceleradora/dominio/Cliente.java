package com.thoughtworks.aceleradora.dominio;

import com.thoughtworks.aceleradora.validadores.anotacoes.RegistraClienteValida;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue(TipoDeUsuario.Valores.CLIENTE)
@Table(name = "clientes")
@RegistraClienteValida
public class Cliente extends Usuario {

    @OneToMany(mappedBy = "cliente")
    private List<MinhaLista> minhasListas;

    public Cliente() {
    }

    public Cliente(String email, String senha, String nome, String contato, Endereco endereco, List<MinhaLista> minhasListas) {
        super(email, senha, nome, contato, endereco);
        this.minhasListas = minhasListas;
    }

    public List<MinhaLista> getMinhasListas() {
        return minhasListas;
    }

    public void setMinhasListas(List<MinhaLista> minhasListas) {
        this.minhasListas = minhasListas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(minhasListas, cliente.minhasListas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minhasListas);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id" + getId() +
                "minhasListas=" + minhasListas +
                '}';
    }
}
