package br.edu.unoesc.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmprestimoController {

    @GetMapping("/emprestimo/cadastro")
    public String cadastro() {
        return "emprestimo/cadastro";
    }

    @GetMapping("/emprestimo/devolucao")
    public String devolver() {
        return "emprestimo/devolucao";
    }

}
