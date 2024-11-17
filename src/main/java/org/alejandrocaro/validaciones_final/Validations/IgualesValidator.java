package org.alejandrocaro.validaciones_final.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class IgualesValidator implements ConstraintValidator<Iguales, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(Iguales constraintAnnotation) {
        this.firstFieldName = constraintAnnotation.first();
        this.secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            // Usamos reflexión para obtener los valores de los campos
            Field firstField = value.getClass().getDeclaredField(firstFieldName);
            Field secondField = value.getClass().getDeclaredField(secondFieldName);

            // Aseguramos acceso a los campos privados
            firstField.setAccessible(true);
            secondField.setAccessible(true);

            // Obtenemos los valores de los campos
            Object firstValue = firstField.get(value);
            Object secondValue = secondField.get(value);

            // Verificamos si ambos valores son iguales
            if (firstValue != null && firstValue.equals(secondValue)) {
                return true; // La validación es exitosa
            }

            // Redirigir el error al campo `repetirClave` (segundo campo)
            context.disableDefaultConstraintViolation(); // Deshabilitar violación predeterminada
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode(secondFieldName) // Asociar el error a `repetirClave`
                    .addConstraintViolation();

            return false; // La validación falla
        } catch (Exception e) {
            // Si ocurre un error en reflexión, retornamos inválido
            return false;
        }
    }
}
