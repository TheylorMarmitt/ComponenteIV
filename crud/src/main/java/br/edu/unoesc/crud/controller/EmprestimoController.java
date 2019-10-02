package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.exception.BestBooksException;
import br.edu.unoesc.crud.model.Devolucao;
import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.service.EmprestimoService;
import br.edu.unoesc.crud.service.ExemplarService;
import br.edu.unoesc.crud.service.ExemplarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @Autowired
    private ExemplarService exemplarService;


    @GetMapping({ "/emprestimo/cadastro", "/emprestimo/cadastro/{codigo}" })
    public String devolver(@PathVariable(value="codigo", required=false) Long codigo, Model model) {
        model.addAttribute("exemplar", new Exemplar());
        model.addAttribute("emprestimo", new Emprestimo());
        if (codigo != null) {
            model.addAttribute("exemplar", exemplarService.getByCodigo(codigo));
        }
        return "devolucao/devolucao";
    }

    @GetMapping("/emprestimo/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("lista", service.listar());
        return "emprestimo/cadastro";
    }



    @PostMapping("/emprestimo/cadastroEnviar")
    public String enviar(Model model, @Valid Emprestimo emprestimo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("emprestimo", emprestimo);
            model.addAttribute("exemplar", emprestimo.getExemplar());
            model.addAttribute("lista", service.listar());
            return "emprestimo/cadastro";
        }
        try {
            service.salvaOuAltera(emprestimo);
        } catch (BestBooksException e) {
            e.printStackTrace();
        }
        return "redirect:/";
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
