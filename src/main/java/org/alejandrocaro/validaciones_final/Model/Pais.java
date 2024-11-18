package org.alejandrocaro.validaciones_final.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor@Getter
public class Pais {
    private String pais;
    private String idioma;
    private String prefijoTelefonicoPais;
    private Boolean muestraIdioma;
    private String nombreArchivoBandera;
}

