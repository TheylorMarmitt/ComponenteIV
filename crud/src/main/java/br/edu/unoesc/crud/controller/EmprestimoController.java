package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.service.EmprestimoService;
import br.edu.unoesc.crud.service.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmprestimoController {

    @Autowired
   private EmprestimoService service;

    @GetMapping("/emprestimo/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("lista", service.listarExemplares());
        return "emprestimo/cadastro";
    }

    @PostMapping("/emprestimo/cadastroEnviar")
    public String enviar(Emprestimo emprestimo) {
        try {
            service.salvar(emprestimo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
    
    @GetMapping("/emprestimo/lista")
    public String listar(Model model) {
    	model.addAttribute("lista", service.listar());
    	return "listas/emprestados";
    }

    @GetMapping("/buscaTitulo")
    public String buscaTitulo(String titulo, Model model){
        model.addAttribute("lista", service.listarTitulo(titulo));
        return "listas/emprestados";
    }

    @GetMapping("/buscaCliente")
    public String buscaCliente(String cliente, Model model){
        model.addAttribute("lista", service.listarCliente(cliente));
        return "listas/emprestados";
    }
}
