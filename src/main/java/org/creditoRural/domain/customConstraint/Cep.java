package org.creditoRural.domain.customConstraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Constraint(validatedBy = {CepValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cep {

    String message() default "Endereco invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };

}
