package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.service.EmprestimoService;
import br.edu.unoesc.crud.service.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmprestimoController {

    @Autowired
    EmprestimoService service;

    @GetMapping("/emprestimo/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("lista", service.listarExemplares());
        return "emprestimo/cadastro";
    }

    @GetMapping("/emprestimo/devolucao")
    public String devolver() {
        return "emprestimo/devolucao";
    }



}
