package com.thoughtworks.aceleradora.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity

@DiscriminatorValue(TipoDeUsuario.Valores.PRODUTOR)
@Table(name = "produtores")
public class Produtor extends Usuario{

    private boolean possuiTransporte;

    public Produtor() {
    }

    public Produtor(String email, String senha, String nome, String contato, Endereco endereco, boolean possuiTransporte) {
        super(email, senha, nome, contato, endereco);
        this.possuiTransporte = possuiTransporte;
    }

    public boolean isPossuiTransporte() {
        return possuiTransporte;
    }

    public void setPossuiTransporte(boolean possuiTransporte) {
        this.possuiTransporte = possuiTransporte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Produtor produtor = (Produtor) o;
        return possuiTransporte == produtor.possuiTransporte;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), possuiTransporte);
    }

    @Override
    public String toString() {
        return "Produtor{" +
                "possuiTransporte=" + possuiTransporte +
                '}';
    }
}