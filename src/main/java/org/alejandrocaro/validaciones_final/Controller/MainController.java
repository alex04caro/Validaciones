package org.alejandrocaro.validaciones_final.Controller;

import org.alejandrocaro.validaciones_final.Model.Colecciones;
import org.alejandrocaro.validaciones_final.Model.DatosFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/formulario")
public class MainController {
    int iteraciones = 1;
    DatosFormulario datosFormulario = new DatosFormulario();


    //Prueba de datos
    /*public void rellenarDatosPrueba(){
        datosFormulario.setNombre("Ales");
        datosFormulario.setClave("Contraseña");
        datosFormulario.setConfirmarClave("Contraseña");
        datosFormulario.setGeneroSeleccionado("M");
        datosFormulario.setFechaNacimiento(LocalDate.of(2004,4,14));
        datosFormulario.setEdad(20);
        datosFormulario.setPaisSeleccionado("pt");
        datosFormulario.setArchivos("Archivo1");
        datosFormulario.setMusicasSeleccionadas(new ArrayList<>(Arrays.asList("E","N","P")));
        datosFormulario.setLicencia(true);
    }*/

    @ModelAttribute
    public void pasarIteraciones(Model modelo) {
        modelo.addAttribute("iteraciones", iteraciones);
    }

    @ModelAttribute
    public void pasarColecciones(Model modelo){
        modelo.addAttribute("listaGeneros",Colecciones.getListaGeneros());
        modelo.addAttribute("listaAficiones",Colecciones.getListaAficiones());
        modelo.addAttribute("listaPaises",Colecciones.getListaPaises());
        modelo.addAttribute("listaMusica",Colecciones.getListaMusicas());
    }

    @GetMapping("devuelve-formulario")
    public String devuelveFormulario(Model modelo) {
        iteraciones++;
        modelo.addAttribute("datosFormulario", datosFormulario);
        return "formulario";
    }

    @GetMapping("recibe-parametros")
    public String recibeParametrosYRepinta(@ModelAttribute DatosFormulario datosFormulario, Model modelo) {
        iteraciones++;
       return "formulario";
    }
}
