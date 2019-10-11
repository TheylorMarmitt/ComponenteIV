package br.edu.unoesc.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.service.PessoaServiceImpl;

@Controller
public class PessoaController {

	@Autowired
	private PessoaServiceImpl service;

	@GetMapping({ "/pessoa/cadastro", "/pessoa/cadastro/{codigo}" })
	public String cadastro(@PathVariable(value="codigo", required=false) Long codigo, Model model) {
		model.addAttribute("pessoa", new Pessoa());
		if (codigo != null) {
			model.addAttribute("pessoa", service.getByCodigo(codigo));
		}
		return "pessoa/cadastro";
	}

	@PostMapping("/pessoa/cadastro")
	public String cadastro(Model model, @Valid Pessoa pessoa, BindingResult bindingResult) {
		System.out.println(pessoa);
		if (bindingResult.hasErrors()) {
			model.addAttribute("pessoa", pessoa);
			return "pessoa/cadastro";
		}
		service.salvaOuAltera(pessoa);
		return "redirect:/";
	}

	@GetMapping("/pessoa/lista")
	public String lista(Model model) {
		model.addAttribute("lista", service.listar());
		return "pessoa/lista";
	}

	@ResponseBody
	@PostMapping("/pessoa/excluir")
	public String excluir(Pessoa pessoa, Model model) {
		service.excluir(pessoa.getCodigo());
		model.addAttribute("lista", service.listar());
		return "pessoa/lista";
	}

}
