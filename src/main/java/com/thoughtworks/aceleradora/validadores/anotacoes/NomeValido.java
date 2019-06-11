package com.thoughtworks.aceleradora.validadores.anotacoes;


import com.thoughtworks.aceleradora.validadores.ValidaListaNome;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidaListaNome.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeValido {
    String message() default "Lista com nome inválido e/ou já existente";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
