package com.tienda.tienda.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping({"/", "/perro"})
    public String index() {
        //log.info("sfedkf");
        return "login";
    }
    
}
 

