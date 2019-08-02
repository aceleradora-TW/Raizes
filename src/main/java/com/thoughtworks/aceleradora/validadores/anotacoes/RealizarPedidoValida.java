package com.thoughtworks.aceleradora.validadores.anotacoes;

import com.thoughtworks.aceleradora.validadores.RealizarPedidoValidador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RealizarPedidoValidador.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RealizarPedidoValida {
    String message() default "Não foi possivel realizar o seu pedido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
