package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    
    @RequestMapping("/") //URL al que responde
    public String index(Model model) {
        model.addAttribute("NombreProfesor", "Jonathan Brenes");
        return "index"; //Nombre de la vista en templates a mostrar
    }
    
    @RequestMapping("/Informacion") //URL al que responde
    public String info() {
        return "info"; //Nombre de la vista en templates a mostrar
    }
}
