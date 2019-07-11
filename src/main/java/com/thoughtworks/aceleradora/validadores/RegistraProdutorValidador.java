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
        return nomeNaoEstaVazio(produtor, context)
                && ruaNaoEstaVazia(produtor, context)
                && bairroNaoEstaVazio(produtor, context)
                && emailNaoEstaVazio(produtor, context)
                && telefoneNaoEstaVazio(produtor, context)
                && senhaNaoEstaVazia(produtor, context);
    }

    private boolean nomeNaoEstaVazio(Produtor produtor, ConstraintValidatorContext context) {
        if (produtor.getNome().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira seu nome completo.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean ruaNaoEstaVazia(Produtor produtor, ConstraintValidatorContext context) {
        if (produtor.getEndereco().getRua().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o nome da sua rua.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean bairroNaoEstaVazio(Produtor produtor, ConstraintValidatorContext context) {
        if (produtor.getEndereco().getBairro().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o nome do seu bairro.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean emailNaoEstaVazio(Produtor produtor, ConstraintValidatorContext context) {
        if (produtor.getEmail().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o seu e-mail.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean telefoneNaoEstaVazio(Produtor produtor, ConstraintValidatorContext context) {
        if (produtor.getContato().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o seu telefone.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean senhaNaoEstaVazia(Produtor produtor, ConstraintValidatorContext context) {
        if (produtor.getSenha().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("crie uma senha.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
