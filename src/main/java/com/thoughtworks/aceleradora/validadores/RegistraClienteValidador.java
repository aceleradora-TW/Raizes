package com.thoughtworks.aceleradora.validadores;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.validadores.anotacoes.RegistraClienteValida;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegistraClienteValidador implements ConstraintValidator<RegistraClienteValida, Cliente> {

    @Override
    public void initialize(RegistraClienteValida constraintAnnotation) {
    }

    @Override
    public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        return nomeNaoEstaVazio(cliente, context)
                && ruaNaoEstaVazia(cliente,context)
                && bairroNaoEstaVazio(cliente, context)
                && emailNaoEstaVazio(cliente, context)
                && telefoneNaoEstaVazio(cliente, context)
                && senhaNaoEstaVazia(cliente, context);
    }

    private boolean nomeNaoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getNome().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira seu nome completo.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
    private boolean ruaNaoEstaVazia(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getEndereco().getRua().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o nome da sua rua.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean bairroNaoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getEndereco().getBairro().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o nome do seu bairro.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean emailNaoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getEmail().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o seu e-mail.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean telefoneNaoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getContato().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o seu telefone.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean senhaNaoEstaVazia(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getSenha().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("crie uma senha.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}