package br.edu.unoesc.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PessoaController {

    @GetMapping("/pessoa/cadastro") public String dashboard(){
        return "pessoa/cadastro";
    }
}
