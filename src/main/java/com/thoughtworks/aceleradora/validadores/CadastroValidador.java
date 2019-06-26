package com.thoughtworks.aceleradora.validadores;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import com.thoughtworks.aceleradora.validadores.anotacoes.CadastroValida;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CadastroValidador implements ConstraintValidator<CadastroValida, ProdutoProdutor> {

    @Autowired
    ProdutoProdutorRepositorio repositorio;

    @Override
    public void initialize(CadastroValida constraintAnnotation) {
    }

    @Override
    public boolean isValid(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        return campoQuantidadeNaoEstaVazio(produtoProdutor, context)
                && campoValorNaoEstaNegativo(produtoProdutor, context)
                && campoQuantidadeEstaNatural(produtoProdutor, context);

    }

    private boolean campoQuantidadeNaoEstaVazio(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getQuantidadeEstoque() == null || produtoProdutor.getPreco() == null) {
            context.buildConstraintViolationWithTemplate("Campo Valor ou Quantidade não podem estar vazios.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }

    private boolean campoQuantidadeEstaNatural(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getQuantidadeEstoque() <= 1) {
            context.buildConstraintViolationWithTemplate("No campo Quantidade, não aceita números negativos ou quebrados.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }

    private boolean campoValorNaoEstaNegativo(ProdutoProdutor produtoProdutor, ConstraintValidatorContext context) {
        if (produtoProdutor.getPreco().doubleValue() <= 0) {
            context.buildConstraintViolationWithTemplate("No campo Valor, são aceitos somente valores iguais ou maiores que ZERO.")
                    .addConstraintViolation();

            return false;
        }
        return true;
    }
}
