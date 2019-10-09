package br.edu.unoesc.crud.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioLogado extends User {

	private static final long serialVersionUID = -8975062327190967567L;
	
	public UsuarioLogado(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
}
