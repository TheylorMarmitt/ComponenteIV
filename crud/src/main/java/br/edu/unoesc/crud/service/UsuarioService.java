package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Usuario;

public interface UsuarioService extends GenericService<Usuario> {

	Usuario findByPessoaEmail(String email);
	
	void novoAdmin(Usuario usuario);
	
	void novoUsuario(Usuario usuario);
	
}
