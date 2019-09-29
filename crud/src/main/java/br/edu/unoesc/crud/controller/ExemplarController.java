package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.service.ExemplarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExemplarController {

    @Autowired
    private ExemplarServiceImpl service;

    @GetMapping("/exemplar/cadastro")
    public String cadastro() {
        return "exemplar/cadastro";
    }

    @PostMapping("/exemplar/enviar")
    public String formulario(Exemplar exemplar) {
        this.service.salvaOuAltera(exemplar);
        return "redirect:/";
    }
}
