package org.alejandrocaro.validaciones_final.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.alejandrocaro.validaciones_final.Model.Colecciones;
import org.alejandrocaro.validaciones_final.Model.DatosFormulario;
import org.alejandrocaro.validaciones_final.Model.DatosFormularioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String devuelveFormulario(@ModelAttribute DatosFormulario datosFormulario, Model modelo, HttpServletRequest request) {

        iteraciones++;
        modelo.addAttribute("metodo","devuelve");
        //Cabeceras HTTP
        String ipCliente = request.getRemoteAddr(); // Dirección IP del cliente
        String navegador = request.getHeader("User-Agent"); // Navegador
        String sistemaOperativo = System.getProperty("os.name"); // Sistema Operativo
        String motorRenderizado = request.getHeader("Sec-Ch-Ua"); // Motor de renderización
        String nombreHost = request.getRemoteHost(); // Nombre del host
        String idiomaYLocale = request.getLocale().toString(); // Idioma y locale

        modelo.addAttribute("ipCliente", ipCliente);
        modelo.addAttribute("navegador", navegador);
        modelo.addAttribute("sistemaOperativo", sistemaOperativo);
        modelo.addAttribute("motorRenderizado", motorRenderizado);
        modelo.addAttribute("nombreHost", nombreHost);
        modelo.addAttribute("idiomaYLocale", idiomaYLocale);
        return "formulario";
    }

    @PostMapping("recibe-parametros")
    public String recibeParametrosYRepinta(
            @Valid @ModelAttribute DatosFormulario datosFormulario,
            BindingResult bindingResult,
            HttpServletRequest request,
            Model modelo,
            @RequestParam(name = "x", required = false) String coordenadaX,
            @RequestParam(name = "y", required = false) String coordenadaY,
            @RequestParam(name = "lang",required = false)String lang){

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

        //Generamos textos que dependen de los errores de validacion
        if(bindingResult.hasErrors()){
            modelo.addAttribute("mensajeNOK","ALERTA: Formulario con errores");
        }else {
            modelo.addAttribute("mensajeOK","ALELUYA: Formulario sin errores");
        }

        //Cabeceras HTTP
        String ipCliente = request.getRemoteAddr(); // Dirección IP del cliente
        String navegador = request.getHeader("User-Agent"); // Navegador
        String sistemaOperativo = System.getProperty("os.name"); // Sistema Operativo
        String motorRenderizado = request.getHeader("Sec-Ch-Ua"); // Motor de renderización
        String nombreHost = request.getRemoteHost(); // Nombre del host
        String idiomaYLocale = request.getLocale().toString(); // Idioma y locale

        modelo.addAttribute("ipCliente", ipCliente);
        modelo.addAttribute("navegador", navegador);
        modelo.addAttribute("sistemaOperativo", sistemaOperativo);
        modelo.addAttribute("motorRenderizado", motorRenderizado);
        modelo.addAttribute("nombreHost", nombreHost);
        modelo.addAttribute("idiomaYLocale", idiomaYLocale);

        //añadimos el leguaje actual de la web
        modelo.addAttribute("lang",lang);
        return "formulario";
    }

}
