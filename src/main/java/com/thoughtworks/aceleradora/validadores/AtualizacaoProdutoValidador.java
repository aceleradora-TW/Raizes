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

        return campoQuantidadeNaoEstaVazio(produtoProdutor, context)
                && campoValorNaoEstaNegativo(produtoProdutor, context)
                && campoValorNaoEstaVazio(produtoProdutor, context)
                && campoQuantidadeEstaNatural(produtoProdutor, context);

    }

    private boolean campoQuantidadeNaoEstaVazio(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getQuantidadeEstoque() == null) {
            context.buildConstraintViolationWithTemplate("*Campo Quantidade não pode estar vazio.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }


    private boolean campoValorNaoEstaVazio(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getQuantidadeEstoque() == null) {
            context.buildConstraintViolationWithTemplate("*Campo Valor não pode estar vazio.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }


    private boolean campoQuantidadeEstaNatural(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getQuantidadeEstoque() <= 1) {
            context.buildConstraintViolationWithTemplate("*No campo Quantidade, são aceitos somente valores NATURAIS.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }

    private boolean campoValorNaoEstaNegativo(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getPreco().doubleValue() <= 0) {
            context.buildConstraintViolationWithTemplate("*No campo Valor, são aceitos somente valores iguais ou maiores que ZERO.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }
}