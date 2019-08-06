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
        return quantidadeNaoEstaVazia(pedido, context)
                && produtoPossuiProdutor(pedido, context);
    }

    private boolean quantidadeNaoEstaVazia(Pedido pedido, ConstraintValidatorContext context) {
        if(pedido.getPedidosProdutosProdutores() != null) {
            for (int i = 0; i < pedido.getPedidosProdutosProdutores().size(); i++) {
                if (pedido.getPedidosProdutosProdutores().get(i).getQuantidadePedido() <= 0) {
                    context.buildConstraintViolationWithTemplate("A quantidade deve ser maior que zero.")
                            .addConstraintViolation();
                    return false;
                }
            }
        }
        return true;
    }

    private boolean produtoPossuiProdutor(Pedido pedido, ConstraintValidatorContext context) {
        if(pedido.getPedidosProdutosProdutores() == null) {
            context.buildConstraintViolationWithTemplate("Selecione ao menos um produtor.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
