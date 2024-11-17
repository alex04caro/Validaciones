package org.alejandrocaro.validaciones_final.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.alejandrocaro.validaciones_final.Validations.EdadCoincideValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EdadCoincideValidator.class)
public @interface EdadCoincide {
    String message() default "{validaciones.edad.coincideFechaNacimiento}"; // Código del mensaje
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
