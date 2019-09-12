package br.edu.unoesc.crud.service;

import java.util.List;

public interface CrudService <T> {

	boolean salvar(T dado);

	boolean excluir (T dado);
	
	List<T> listar();
}
