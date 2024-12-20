package org.alejandrocaro.validaciones_final.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = MusicaMinimaValidator.class)
@Documented

public @interface MusicaMinima {

    String message() default "{validaciones.musicasSeleccionadas.minimo}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    int value();

}
