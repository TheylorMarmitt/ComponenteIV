package br.edu.unoesc.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.unoesc.crud.model.Usuario;
import br.edu.unoesc.crud.model.UsuarioLogado;

@Service
public class UsuarioBancoService implements UserDetailsService {

	
	@Autowired
	private UsuarioService service;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = service.getUsuarioPorEmail(username);
		
		return new UsuarioLogado(usuario.getEmail(), usuario.getSenha(), usuario.getPermissoes());
	}

}
