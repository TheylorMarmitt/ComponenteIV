package br.edu.unoesc.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.crud.model.Usuario;
import br.edu.unoesc.crud.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/admin/novo")
	public String novo() {
		return "usuario/cadastro";
	}

	@GetMapping("/cadastro")
	public String novoCadastro(Usuario usuario) {
		service.novoUsuario(usuario);
		return "usuario/cadastro";
	}

	@PostMapping("/admin/novo")
	public String salvar(Usuario usuario) {
		service.novoAdmin(usuario);
		return "/";
	}
	
	@PostMapping("/cadastro")
	public String novoUsuario(Usuario usuario) {
		service.novoAdmin(usuario);
		return "/";
	}
}
