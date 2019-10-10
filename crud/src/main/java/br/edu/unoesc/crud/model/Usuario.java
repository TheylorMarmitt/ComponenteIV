package br.edu.unoesc.crud.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario extends Pessoa implements EntidadePersistente {

	private static final long serialVersionUID = 6217356586088299344L;

	private String senha;
	
	@OneToMany
	private List<Permissao> permissoes = new ArrayList<Permissao>();

	public String getSenha() {
		return senha;
	}


	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
