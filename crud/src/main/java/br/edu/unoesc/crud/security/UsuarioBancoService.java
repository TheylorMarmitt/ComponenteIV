package br.edu.unoesc.crud.security;

import br.edu.unoesc.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.unoesc.crud.model.Usuario;

@Service
public class UsuarioBancoService implements UserDetailsService {

	
	@Autowired
	private UsuarioService service;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = service.findByPessoaEmail(username);
		if(usuario == null) return null;
		return new UsuarioLogado(usuario.getPessoa().getEmail(), usuario.getSenha(), usuario.getPermissoes());
	}

}
