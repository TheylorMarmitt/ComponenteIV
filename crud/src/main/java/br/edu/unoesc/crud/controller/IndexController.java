package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import br.edu.unoesc.crud.service.EmprestimoService;
import br.edu.unoesc.crud.service.ExemplarServiceImpl;
import br.edu.unoesc.crud.service.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

	@Autowired
	private ExemplarServiceImpl exemplarService;

	@Autowired
	private PessoaServiceImpl pessoaService;

	@Autowired
	private EmprestimoService emprestimoService;

	@GetMapping("/")
	public String dashboard(Model model) {

		model.addAttribute("qtdExemplares", exemplarService.quantidade());
		model.addAttribute("qtdPessoas", pessoaService.quantidade());
		model.addAttribute("qtdEmprestimos", emprestimoService.quantidade());
		model.addAttribute("qtdEmprestados", emprestimoService.quantidadeEmprestadosAtivos());
		return "index";
	}

	@RequestMapping(path = "/dadosGrafico")
	public @ResponseBody List<Exemplar> dados() {
		return exemplarService.listar();
	}

}
