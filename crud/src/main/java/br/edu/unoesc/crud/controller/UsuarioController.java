package br.edu.unoesc.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
	
	 @GetMapping("/usuario/novo")
	    public String novo(){
	        return "usuario/cadastro";
	    }
	 	
	 
	 @PostMapping("/usuario/novo")
	    public String salvar(){
	        return "/";
	    }
}
