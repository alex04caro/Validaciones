package org.alejandrocaro.validaciones_final.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.alejandrocaro.validaciones_final.Model.DatosFormulario;

import java.time.LocalDate;
import java.time.Period;

public class EdadCoincideValidator implements ConstraintValidator<EdadCoincide, DatosFormulario> {
    int edad;
    private String message; // Guardar el mensaje

    @Override
    public void initialize(EdadCoincide constraintAnnotation) {
        this.message = constraintAnnotation.message(); // Obtener el mensaje desde la anotación
    }

    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext context) {
        if (datosFormulario == null) {
            return true; // No validamos si el objeto es null
        }

        LocalDate fechaNacimiento = datosFormulario.getFechaNacimiento();
        try {
            edad = datosFormulario.getEdad();
        }catch(NullPointerException npe){
            return false;
        }


        if (fechaNacimiento != null) {
            int edadCalculada = Period.between(fechaNacimiento, LocalDate.now()).getYears();
            if (edad != edadCalculada) {
                // Deshabilitar la violación predeterminada y redirigir al campo 'edad'
                context.disableDefaultConstraintViolation();

                // Construir la violación personalizada con el mensaje desde la anotación
                context.buildConstraintViolationWithTemplate(message)
                        .addPropertyNode("edad") // Asociar el error al campo 'edad'
                        .addConstraintViolation();

                return false; // La validación no fue exitosa
            }
        }

        return true; // La validación fue exitosa
    }
}
