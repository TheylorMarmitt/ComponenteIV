package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.exception.BestBooksException;
import br.edu.unoesc.crud.model.Devolucao;
import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.service.DevolucaoService;
import br.edu.unoesc.crud.service.EmprestimoService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DevolucaoController {

	@Autowired
	private DevolucaoService devolucaoService;

    @Autowired
    private EmprestimoService emprestimoService;


    @GetMapping({ "/devolucao/devolucao", "/devolucao/devolucao/{codigo}" })
    public String devolver(@PathVariable(value="codigo", required=false) Long codigo, Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        if (codigo != null) {
            model.addAttribute("emprestimo", emprestimoService.getByCodigo(codigo));
        }
        return "devolucao/devolucao";
    }

    @PostMapping("/devolucao/enviar")
    public String enviar(Model model, @Valid Devolucao devolucao, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("devolucao", devolucao);
            return "devolucao/devolucao";
        }

        try {
            devolucaoService.salvaOuAltera(devolucao);

        } catch (BestBooksException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
