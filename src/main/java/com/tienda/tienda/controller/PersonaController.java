package com.tienda.tienda.controller;

import com.tienda.tienda.entity.Personas;
import com.tienda.services.IPersonaService;
import java.util.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PersonaController {
    @AutoWired 
    private IPersonaService personaService;
    
    @GetMapping("/personas")
    public String index(Model model){
    List<Persona> listaPersonas=personaService.getAllPerson();
    model.addAttribute("titulo","Personas");
    model.addAttribute("personas",listaPersonas);
    return "personas";
    }
}