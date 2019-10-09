package br.edu.unoesc.crud.model;

import java.util.HashSet;
import java.util.Set;

public class Usuario  extends Pessoa implements EntidadePersistente{

	private static final long serialVersionUID = 6217356586088299344L;

	private Long codigo;
	private String senha;
	private Set<String> permissoes = new HashSet<String>();
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getSenha() {
		return senha;
	}
	public Set<String> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(Set<String> permissoes) {
		this.permissoes = permissoes;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
