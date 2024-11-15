package org.alejandrocaro.validaciones_final.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formulario")
public class MainController {
    @GetMapping("devuelve-formulario")
    public String devuelveFormulario() {
        return "formulario";
    }
}
