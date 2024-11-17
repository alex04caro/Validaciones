package org.alejandrocaro.validaciones_final.Validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.alejandrocaro.validaciones_final.Model.Colecciones;

import java.util.Map;

public class ContenidoEnGenerosValidator implements ConstraintValidator<ContenidoEnGeneros, String> {

    private static final Map<String, String> listaGeneros = Colecciones.getListaGeneros();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Si el valor es null o vacío, lo consideramos inválido
        if (value == null || value.isEmpty()) {
            return false;
        }

        // Comprobamos si el valor está contenido en la lista de géneros
        return listaGeneros.containsKey(value);
    }
}
