package br.edu.unoesc.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExemplarController {

    @GetMapping("/exemplar/cadastro")
    public String cadastro() {
        return "exemplar/cadastro";
    }
}
