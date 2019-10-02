package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.service.ExemplarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ExemplarController {

    @Autowired
    private ExemplarServiceImpl service;

    @GetMapping("/exemplar/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("exemplar", new Exemplar());
        return "exemplar/cadastro";
    }

    @PostMapping("/exemplar/enviar")
    public String formulario(@Valid @ModelAttribute("exemplar") Exemplar exemplar, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("exemplar", exemplar);
            return "exemplar/cadastro";
        }
        this.service.salvaOuAltera(exemplar);
        return "redirect:/";
    }
}
