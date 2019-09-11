package br.edu.unoesc.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.crud.model.Pessoa;

@Controller
public class PessoaController {

    @GetMapping("/pessoa/cadastro")
    public String cadastro(){
        return "pessoa/cadastro";
    }
   
    
    @PostMapping("/pessoa/cadastro")
    public String cadastro(Pessoa pessoa) {
    	return "pessoa/cadastro";
    }
    
}
