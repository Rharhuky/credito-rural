package org.creditoRural.domain.customConstraint;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class Validacao {

    private static final ValidatorFactory factory;
    private static final Validator validator;

    private Validacao(){}

    static{

        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    public static <T> Set<ConstraintViolation<T>> validateEntity(T entidade){
        return validator.validate(entidade);

    }

}
