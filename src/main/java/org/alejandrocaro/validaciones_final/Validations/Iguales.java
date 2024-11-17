package org.alejandrocaro.validaciones_final.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IgualesValidator.class)
@Target({ ElementType.TYPE }) // Se aplica a nivel de clase
@Retention(RetentionPolicy.RUNTIME)
public @interface Iguales {
    String message() default "{validaciones.repetirClave.iguales}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String first(); // Primer campo
    String second(); // Segundo campo

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        Iguales[] value(); // Soporte para múltiples validaciones en una clase
    }
}