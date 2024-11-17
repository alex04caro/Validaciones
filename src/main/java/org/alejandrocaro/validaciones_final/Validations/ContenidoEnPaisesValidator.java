package org.alejandrocaro.validaciones_final.Validations;



import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.alejandrocaro.validaciones_final.Model.Colecciones;
import org.alejandrocaro.validaciones_final.Model.Pais;

import java.util.Map;

public class ContenidoEnPaisesValidator implements ConstraintValidator<ContenidoEnPaises, String> {

    private static final Map<String, Pais> listaPaises = Colecciones.getListaPaises();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Si el valor es null o vacío, lo consideramos inválido
        if (value == null || value.isEmpty()) {
            return false;
        }


        return listaPaises.containsKey(value);
    }
}

