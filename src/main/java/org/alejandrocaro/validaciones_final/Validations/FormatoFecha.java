package org.alejandrocaro.validaciones_final.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FormatoFechaValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FormatoFecha {
    String message() default "{validaciones.fechaNacimiento.formato}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

