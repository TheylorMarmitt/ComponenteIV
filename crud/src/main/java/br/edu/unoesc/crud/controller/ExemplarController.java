package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.service.ExemplarService;
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
    private ExemplarService service;

    @GetMapping("/exemplar/cadastro")
    public String cadastro() {
        return "exemplar/cadastro";
    }

    @PostMapping("/exemplar/enviar")
    public String formulario(Model model, @Valid @ModelAttribute("Exemplar") Exemplar exemplar, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            model.addAttribute("exemplar", exemplar);
            return "exemplar/cadastro";
        }
        this.service.salvaOuAltera(exemplar);
        return "redirect:/";
    }
}
