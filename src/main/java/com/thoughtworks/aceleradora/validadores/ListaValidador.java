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
        context.disableDefaultConstraintViolation();

        return nomeAindaNaoExisteNoBanco(minhaLista, context)
                && nomeNaoEstaVazio(minhaLista, context)
                && listaContemProdutos(minhaLista, context);
    }

    private boolean nomeAindaNaoExisteNoBanco(MinhaLista lista, ConstraintValidatorContext context) {
        Optional<MinhaLista> listaComConflito = repositorio.findByNome(lista.getNome());

        if(listaComConflito.isPresent() && !listaComConflito.get().getId().equals(lista.getId())) {
            context.buildConstraintViolationWithTemplate("Nome da lista deve ser único.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }

    private boolean nomeNaoEstaVazio(MinhaLista lista, ConstraintValidatorContext context) {
        if(lista.getNome().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Nome da lista não pode ser vazio.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }

    private boolean listaContemProdutos(MinhaLista minhaLista, ConstraintValidatorContext context) {
        if(minhaLista.getProdutos().isEmpty()) {
            context.buildConstraintViolationWithTemplate("É necessário escolher ao menos um produto!")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
}
