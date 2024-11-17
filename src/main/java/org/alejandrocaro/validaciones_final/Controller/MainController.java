package org.alejandrocaro.validaciones_final.Controller;

import org.alejandrocaro.validaciones_final.Model.Colecciones;
import org.alejandrocaro.validaciones_final.Model.DatosFormulario;
import org.alejandrocaro.validaciones_final.Model.DatosFormularioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.MessageSource;


@Controller
@RequestMapping("/formulario")
public class MainController {
    int iteraciones = 1;
    DatosFormulario datosFormulario = new DatosFormulario();
    @Autowired
    private MessageSource messageSource;


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
    public String devuelveFormulario(@ModelAttribute DatosFormulario datosFormulario, Model modelo) {

        iteraciones++;
        modelo.addAttribute("metodo","devuelve");
        return "formulario";
    }

    @GetMapping("recibe-parametros")
    public String recibeParametrosYRepinta(@ModelAttribute DatosFormulario datosFormulario, Model modelo,
                                           @RequestParam(name = "x", required = false) String coordenadaX,
                                           @RequestParam(name = "y", required = false) String coordenadaY) {

        iteraciones++;
        //Generemos un mensaje personalizado para que se muestre el numero de parametros recibidos y cuales son (sin tener en cuenta los nulos)
        DatosFormulario datos= (DatosFormulario) modelo.getAttribute("datosFormulario");
        String[]resultado;
        resultado=DatosFormularioUtils.obtenerAtributosNoNulos(datos);
        String mensajeConteoParametros = messageSource.getMessage("validaciones.conteoParametros", new Object[]{resultado[0], resultado[1]}, LocaleContextHolder.getLocale());
        modelo.addAttribute("mensajeConteoParametros",mensajeConteoParametros);
        //Generamos el mensaje de las coordenadas de clic de la imagen
        String mensajeCoordenadas = messageSource.getMessage("validaciones.coordenadas", new Object[]{coordenadaX, coordenadaY}, LocaleContextHolder.getLocale());
        modelo.addAttribute("mensajeCoordenadas",mensajeCoordenadas);
        modelo.addAttribute("metodo","repinta");

        return "formulario";
    }

}
