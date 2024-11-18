package org.alejandrocaro.validaciones_final.Validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Anotación personalizada
@Constraint(validatedBy = ContactoRequeridoValidator.class) // Referencia al validador
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactoRequerido {
    String message() default "{validaciones.contacto.minimo}"; // Mensaje por defecto
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

