package br.edu.unoesc.crud.model;

public class Usuario  extends Pessoa implements EntidadePersistente{

	private static final long serialVersionUID = 6217356586088299344L;

	private Long codigo;
	private String senha;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
