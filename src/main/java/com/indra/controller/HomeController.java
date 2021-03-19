package com.indra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.indra.model.Usuario;

@Controller
public class HomeController {

	
	@GetMapping("/")
    String index(Usuario usuario) {
        return usuario != null ? "redirect:/home" :"" ;
    }
	
	
	@GetMapping("/home")
    public String home() {
        return"home" ;
    }
	
	@GetMapping("/prueba")
    public String prueba() {
        return"prueba" ;
    }
}
