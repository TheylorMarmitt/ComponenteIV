package br.edu.unoesc.crud.service;

import java.util.List;

public interface CrudService <T> {

	T salvar(T dado);
	
	T excluir (T dado);
	
	List<T> listar();
}
