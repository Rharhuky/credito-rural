package org.creditoRural.customConstraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Anotação que verifica a existência de um CEP informado em um campo marcado com esta.
 * @since 2023 - brincando com JPA
 * @author rharhuandrew
 */
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
