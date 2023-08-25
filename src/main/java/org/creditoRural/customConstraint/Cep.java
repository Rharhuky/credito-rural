package org.creditoRural.customConstraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Constraint(validatedBy = {CepValidator.class})
@Retention(RetentionPolicy.RUNTIME)
//@ReportAsSingleViolation
//@Documented
public @interface Cep {

    String message() default "Cep não encontrado !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };

}
