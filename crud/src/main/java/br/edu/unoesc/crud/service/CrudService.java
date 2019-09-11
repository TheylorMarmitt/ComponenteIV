package br.edu.unoesc.crud.service;

import java.util.List;

public interface CrudService <T> {

	void salvar(T dado);
	
	void excluir (T dado);
	
	List<T> listar();
}
