package org.alejandrocaro.validaciones_final.Model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.alejandrocaro.validaciones_final.Validations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.util.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString

@Iguales(first = "clave", second = "confirmarClave", message = "Las claves deben ser iguales")
@EdadCoincide(message = "{validaciones.edad.coincideFechaNacimiento}")
public class DatosFormulario {

    @NotEmpty
    @NotNull
    private String nombre;

    @NotEmpty
    @NotNull
    @Size(min = 6, max = 12, message = "{validaciones.clave.size}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%&]).*$", message = "{validaciones.clave.pattern}")
    private String clave;

    @NotEmpty
    @NotNull
    private String confirmarClave;

    @NotEmpty
    @NotBlank
    @ContenidoEnGeneros
    private String generoSeleccionado;

    @NotNull
    @NotEmpty
    @ContenidoEnPaises
    private String paisSeleccionado;

    @NotNull
    @FormatoFecha
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @FechaPasada(value = 18,message = "{validaciones.fecha.mayorEdad}")
    private LocalDate fechaNacimiento;


    @NotNull
    @Digits(integer = 3, fraction = 0,message = "{validaciones.edad.entero}")
    private Integer edad;

    @NotNull
    @Digits( integer = 10, fraction = 10, message = "{validaciones.peso.numeroReal}")
    private Float peso;

    @NotNull
    @ContenidoEnPaises
    private String prefijoTelefonico;

    @NotNull
    @Max(value = 999999999,message = "{validaciones.telefono.digits}")
    @Min(value = 100000000,message = "{validaciones.telefono.digits}")
    private String telefono;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}$",message = "{validaciones.email.pattern}")
    private String email;

    @NotNull
    private String url;

    @NotNull
    @Pattern(regexp = ".*\\\\.(pdf|jpg|jpeg|gif)$",message = "{validaciones.file.pattern}")
    private String archivos;

    @MusicaMinima(1)
    private List<String> musicasSeleccionadas;

    @AficionesMinima(2)
    private List<String> aficionesSeleccionadas;

    @NotNull
    private String comentarios;

    @NotNull
    private Boolean licencia;
}