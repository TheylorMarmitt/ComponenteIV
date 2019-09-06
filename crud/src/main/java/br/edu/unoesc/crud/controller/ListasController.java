package br.edu.unoesc.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListasController {

    @GetMapping("/listas/disponiveis") public String disponiveis(){
        return "listas/disponiveis";
    }

    @GetMapping("/listas/emprestados") public String emprestados(){
        return "listas/emprestados";
    }
}
