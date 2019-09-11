package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExemplarController {

    @Autowired
    ExemplarRepository repository;

    @GetMapping("/exemplar/cadastro")
    public String cadastro() {
        return "exemplar/cadastro";
    }

    @PostMapping("/exemplar/enviar")
    public String formulario(Exemplar exemplar) {
        this.repository.save(exemplar);

        return "index";
    }
}
