package com.thoughtworks.aceleradora.validadores.anotacoes;


import com.thoughtworks.aceleradora.validadores.RegistraProdutorValidador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RegistraProdutorValidador.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RegistraProdutorValida {
    String message() default "Registro inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
