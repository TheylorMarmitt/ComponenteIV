package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Devolucao;
import br.edu.unoesc.crud.service.DevolucaoService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DevolucaoController {

    @Autowired
    DevolucaoService devolucaoService;

    @GetMapping("/devolucao/devolucao")
    public String devolver() {
        return "devolucao/devolucao";
    }

    @PostMapping("/devolucao/enviar")
    public String enviar(Devolucao devolucao){
        try {
            devolucaoService.salvar(devolucao);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
