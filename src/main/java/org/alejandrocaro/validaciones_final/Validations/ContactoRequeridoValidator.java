package org.alejandrocaro.validaciones_final.Validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.alejandrocaro.validaciones_final.Model.DatosFormulario;
import java.lang.reflect.Field;

public class ContactoRequeridoValidator implements ConstraintValidator<ContactoRequerido, DatosFormulario> {

    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext context) {
        boolean esValido = true;

        // Verificar si ambos campos están vacíos
        if ((datosFormulario.getTelefono() == null || datosFormulario.getTelefono().isEmpty()) &&
                (datosFormulario.getEmail() == null || datosFormulario.getEmail().isEmpty())) {

            // Si ambos campos están vacíos, agregamos el error a ambos campos
            esValido = false;

            // Redirigir el mensaje de error a 'telefono'
            context.buildConstraintViolationWithTemplate("{validaciones.contacto.minimo}")
                    .addPropertyNode("telefono") // Error en el campo telefono
                    .addConstraintViolation();

            // Redirigir el mensaje de error a 'email'
            context.buildConstraintViolationWithTemplate("{validaciones.contacto.minimo}")
                    .addPropertyNode("email") // Error en el campo email
                    .addConstraintViolation();
        }

        return esValido;
    }
}

