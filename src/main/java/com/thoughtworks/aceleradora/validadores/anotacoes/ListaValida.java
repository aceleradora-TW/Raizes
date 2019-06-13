package com.thoughtworks.aceleradora.validadores.anotacoes;


import com.thoughtworks.aceleradora.validadores.ListaValidador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ListaValidador.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ListaValida {
    String message() default "Lista inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
