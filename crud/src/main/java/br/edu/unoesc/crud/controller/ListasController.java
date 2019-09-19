package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.service.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListasController {

    @Autowired
    ExemplarService exemplarService;

    @GetMapping("/listas/disponiveis") public String disponiveis(Model model){
        model.addAttribute("lista", exemplarService.findDisponiveis());
        return "listas/disponiveis";
    }

    @GetMapping("/buscaExemplarTitulo") public String busca( String titulo, Model model){

        model.addAttribute("lista", exemplarService.findDisponiveisNome(titulo));
        return "listas/disponiveis";
    }

}
