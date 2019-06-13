package com.thoughtworks.aceleradora.validadores;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import com.thoughtworks.aceleradora.validadores.anotacoes.ListaValida;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ListaValidador implements ConstraintValidator<ListaValida, MinhaLista> {
    @Autowired
    MinhaListaRepositorio repositorio;

    @Override
    public void initialize(ListaValida constraintAnnotation) {
    }

    @Override
    public boolean isValid(MinhaLista minhaLista, ConstraintValidatorContext context) {
        boolean ehValido;

        ehValido = nomeAindaNaoExisteNoBanco(minhaLista, context);
        ehValido &= nomeNaoEstaVazio(minhaLista, context);
        ehValido &= listaContemProdutos(minhaLista, context);

        return ehValido;
    }

    private boolean nomeAindaNaoExisteNoBanco(MinhaLista lista, ConstraintValidatorContext context) {
        Optional<MinhaLista> listaComConflito = repositorio.findByNome(lista.getNome());

        if(listaComConflito.isPresent() && !listaComConflito.get().equals(lista)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Nome da lista deve ser único.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }

    private boolean nomeNaoEstaVazio(MinhaLista lista, ConstraintValidatorContext context) {
        if(lista.getNome().trim().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Nome da lista não pode ser vazio.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }

    private boolean listaContemProdutos(MinhaLista minhaLista, ConstraintValidatorContext context) {
        if(minhaLista.getProdutos().isEmpty()) {
            context.disableDefaultConstraintViolation();;
            context.buildConstraintViolationWithTemplate("É necessário escolher ao menos um produto!")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
}
