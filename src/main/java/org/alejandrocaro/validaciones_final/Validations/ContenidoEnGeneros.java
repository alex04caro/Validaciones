package org.alejandrocaro.validaciones_final.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Se aplica a campos de tipo String
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContenidoEnGenerosValidator.class)
public @interface ContenidoEnGeneros {

    // Mensaje de error que se mostrará si la validación falla
    String message() default "{validaciones.pais.enLista}";

    // Permite agrupar las validaciones
    Class<?>[] groups() default {};

    // Permite incluir información adicional sobre la validación
    Class<? extends Payload>[] payload() default {};
}
