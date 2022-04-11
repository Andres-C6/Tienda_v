package com.tienda.tienda.controller;

import com.tienda.tienda.entity.Persona;
import com.tienda.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/persona")
    public String index(Model model) {
        List<Persona> listaPersonas = personaService.getAllPerson();
        model.addAttribute("titulo", "Personas");
        model.addAttribute("personas", listaPersonas);
        return "personas";
    }
    
    @GetMapping("/nuevaPersona")
    public String nuevaPersona(Persona persona) {
        return "modificarPersona";
    }
    
    
    /*
    @GetMapping("/modificarPersona/{idPersona}")
    public String modificarPersona(Persona persona, Model model) {
        persona = personaService.getPersonById(persona);
        model.addAttribute("persona", persona);
        return "modificarPersona";
    }
*/
    
    
    @GetMapping("/personasN")
    public String crearPersona(Model model) {
        model.addAttribute("personas",new Persona());
        //persona.Service.savePerson(persona);
        //return "modificarPersona";
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePerson(persona);
        return "redirect:/Persona";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id")Long idPersona) {
        personaService.delete(idPersona);
        return "redirect:/persona";
    }
    
}
