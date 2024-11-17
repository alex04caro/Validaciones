package org.alejandrocaro.validaciones_final.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormatoFechaValidator implements ConstraintValidator<FormatoFecha, LocalDate> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) return true; // @NotNull se encarga de validar nulos

        try {
            String formattedDate = value.format(FORMATTER);
            LocalDate.parse(formattedDate, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

