package br.edu.unoesc.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.reflection.CamposDinamicos;
import br.edu.unoesc.crud.service.PessoaService;

@Controller
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping("/pessoa/cadastro")
	public String cadastro() {
		return "pessoa/cadastro";
	}

	@PostMapping("/pessoa/cadastro")
	public String cadastro(Model model, Pessoa pessoa) {
		service.salvar(pessoa);
		return "pessoa/cadastro";
	}

	@GetMapping("/pessoa/lista")
	public String lista(Model model) {
		List<Pessoa> pessoas = service.listar();
		model.addAttribute("lista", new CamposDinamicos<>(pessoas, Pessoa.class));
		return "pessoa/lista";
	}

}
