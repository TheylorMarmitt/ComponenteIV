package br.edu.unoesc.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DevolucaoController {

    @GetMapping("/devolucao/devolucao")
    public String devolver() {
        return "devolucao/devolucao";
    }

    @PostMapping("/devolucao/enviar")
    public String enviar(){

        return "index";
    }
}
