package com.thoughtworks.aceleradora.validadores;

import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.validadores.anotacoes.RealizarPedidoValida;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RealizarPedidoValidador implements ConstraintValidator<RealizarPedidoValida, Pedido> {
    @Override
    public void initialize(RealizarPedidoValida constraintAnnotation) {

    }


    @Override
    public boolean isValid(Pedido pedido, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        return quantidadeNaoEstaVazia(pedido, context);
    }

    private boolean quantidadeNaoEstaVazia(Pedido pedido, ConstraintValidatorContext context) {
        for (int i = 0; i < pedido.getPedidosProdutosProdutores().size(); i++) {
            if (pedido.getPedidosProdutosProdutores().get(i).getQuantidadePedido() <= 0) {
                context.buildConstraintViolationWithTemplate("A quantidade deve ser maior que zero")
                        .addConstraintViolation();
                return false;
            }
        }

        return true;
    }
//
//    private boolean ruaNaoEstaVazia(Cliente cliente, ConstraintValidatorContext context) {
//        if (cliente.getEndereco().getRua().trim().isEmpty()) {
//            context.buildConstraintViolationWithTemplate("insira o nome da sua rua.")
//                    .addConstraintViolation();
//            return false;
//        }
//        return true;
//    }
//
//    private boolean bairroNaoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
//        if (cliente.getEndereco().getBairro().trim().isEmpty()) {
//            context.buildConstraintViolationWithTemplate("insira o nome do seu bairro.")
//                    .addConstraintViolation();
//            return false;
//        }
//        return true;
//    }
//
//    private boolean emailNaoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
//        if (cliente.getEmail().trim().isEmpty()) {
//            context.buildConstraintViolationWithTemplate("insira o seu e-mail.")
//                    .addConstraintViolation();
//            return false;
//        }
//        return true;
//    }
//
//    private boolean telefoneNaoEstaVazio(Cliente cliente, ConstraintValidatorContext context) {
//        if (cliente.getContato().trim().isEmpty()) {
//            context.buildConstraintViolationWithTemplate("insira o seu telefone.")
//                    .addConstraintViolation();
//            return false;
//        }
//        return true;
//    }
//
//    private boolean senhaNaoEstaVazia(Cliente cliente, ConstraintValidatorContext context) {
//        if (cliente.getSenha().trim().isEmpty()) {
//            context.buildConstraintViolationWithTemplate("crie uma senha.")
//                    .addConstraintViolation();
//            return false;
//        }
//        return true;
//    }
//
//    private boolean emailAindaNaoExisteNoBanco(Cliente cliente, ConstraintValidatorContext context) {
//        Optional<Cliente> emailExistente = repositorio.findByEmail(cliente.getEmail());
//
//        if (emailExistente.isPresent()) {
//            context.buildConstraintViolationWithTemplate("Email já existente")
//                    .addConstraintViolation();
//
//            return false;
//        }
//
//        return true;
//    }
}
