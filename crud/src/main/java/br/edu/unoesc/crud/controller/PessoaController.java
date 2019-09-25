package br.edu.unoesc.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.service.PessoaService;

@Controller
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping({ "/pessoa/cadastro", "/pessoa/cadastro/{codigo}" })
	public String cadastro(@PathVariable(value="codigo", required=false) Long codigo, Model model) {
		
		if (codigo != null) {
			model.addAttribute("pessoa", service.getByCodigo(codigo).get());
		}
		
		return "pessoa/cadastro";
	}

	@PostMapping("/pessoa/cadastro")
	public String cadastro(Model model, @Valid Pessoa pessoa, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("pessoa", pessoa);
			return "pessoa/cadastro";
		}
		service.salvaOuAltera(pessoa);
		return "pessoa/cadastro";
	}

	@GetMapping("/pessoa/lista")
	public String lista(Model model) {
		List<Pessoa> pessoas = service.listar();
		model.addAttribute("lista", pessoas);
		return "pessoa/lista";
	}

	@PostMapping("/pessoa/excluir")
	public ResponseEntity<String> excluir(Pessoa pessoa) {
		service.excluir(pessoa);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
