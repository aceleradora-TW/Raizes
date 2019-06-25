package com.thoughtworks.aceleradora.validadores;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import com.thoughtworks.aceleradora.validadores.anotacoes.AtualizacaoProdutoValida;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AtualizacaoProdutoValidador implements ConstraintValidator<AtualizacaoProdutoValida, ProdutoProdutor> {

    @Autowired
    ProdutoProdutorRepositorio repositorio;

    @Override
    public void initialize(AtualizacaoProdutoValida constraintAnnotation) {
    }

    @Override
    public boolean isValid(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        return camposNaoEstaoVazios(produtoProdutor, context)
                && camposNaoEstaoVazios(produtoProdutor, context)
                && camposComValoresPositivos(produtoProdutor, context)
                && quantidadeEmEstoqueMaiorQueZero(produtoProdutor, context);
    }

    private boolean camposNaoEstaoVazios(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getQuantidadeEstoque() == null || produtoProdutor.getPreco() == null) {
            context.buildConstraintViolationWithTemplate("Quantidade ou Valor não deve estar vazio.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }

    private boolean camposComValoresPositivos(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getQuantidadeEstoque() < 0 || produtoProdutor.getPreco().doubleValue() < 0) {
            context.buildConstraintViolationWithTemplate("Quantidade ou Valor não devem ser negativos.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }

    private boolean quantidadeEmEstoqueMaiorQueZero(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getQuantidadeEstoque() < 1) {
            context.buildConstraintViolationWithTemplate("Quantidade em estoque deve ser maior que zero.")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }


}