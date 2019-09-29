package br.edu.unoesc.crud.service;

import java.util.List;

import br.edu.unoesc.crud.model.EntidadePersistente;

public interface GenericService <T extends EntidadePersistente> {
	
	T salvaOuAltera(T dado);

	List<T> listar();

	T excluir (Long codigo);
	
	T getByCodigo(Long codigo);
	
}
