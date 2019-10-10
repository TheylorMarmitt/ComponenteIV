package br.edu.unoesc.crud.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements EntidadePersistente {

	private static final long serialVersionUID = 6217356586088299344L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String senha;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@Override
	public Long getCodigo() {
		return codigo;
	}
	
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
