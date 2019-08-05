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
}
