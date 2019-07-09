package com.thoughtworks.aceleradora.validadores;

import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.validadores.anotacoes.RegistraProdutorValida;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegistraProdutorValidador implements ConstraintValidator<RegistraProdutorValida, Produtor> {

    @Override
    public void initialize(RegistraProdutorValida constraintAnnotation) {

    }

    @Override
    public boolean isValid(Produtor produtor, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        return nomeNaoEstaVazio(produtor, context);
    }

    private boolean nomeNaoEstaVazio(Produtor produtor, ConstraintValidatorContext context) {
        if (produtor.getNome().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira seu nome completo.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
