package com.thoughtworks.aceleradora.validadores;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.repositorios.ClienteRepositorio;
import com.thoughtworks.aceleradora.validadores.anotacoes.RegistraClienteValida;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegistraClienteValidador implements ConstraintValidator<RegistraClienteValida, Cliente> {
    @Autowired
    ClienteRepositorio repositorio;

    @Override
    public void initialize(RegistraClienteValida constraintAnnotation) {
    }

    @Override
    public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        return nomeNaoEstaVazio(cliente, context)
                && ruaNãoEstaVazia(cliente,context)
                && bairroNãoEstaVazio(cliente, context)
                && emailNãoEstaVazio(cliente, context)
                && telefoneNãoEstaVazio(cliente, context)
                && senhaNãoEstaVazia(cliente, context);
    }

    private boolean nomeNaoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getNome().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira seu nome completo.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
    private boolean ruaNãoEstaVazia(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getEndereco().getRua().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o nome da sua rua.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean bairroNãoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getEndereco().getBairro().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o nome do seu bairro.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean emailNãoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getEmail().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o seu e-mail.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean telefoneNãoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getContato().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("insira o seu telefone.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
    private boolean senhaNãoEstaVazia(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente.getSenha().trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("crie uma senha.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}