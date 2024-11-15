package org.alejandrocaro.validaciones_final.Model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString

public class DatosFormulario {
    private String nombre;
    private String clave;
    private String confirmarClave;
    private String generoSeleccionado;
    private String paisSeleccionado;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private Float peso;
    private String prefijoTelefonico;
    private String telefono;
    private String email;
    private String url;
    private String archivos;
    private List<String> musicasSeleccionadas;
    private List<String> aficionesSeleccionadas;
    private String comentarios;
    private Boolean licencia;

}