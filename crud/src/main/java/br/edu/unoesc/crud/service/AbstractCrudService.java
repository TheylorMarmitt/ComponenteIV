package br.edu.unoesc.crud.service;

import java.util.List;

import br.edu.unoesc.crud.model.EntidadePersistente;
import br.edu.unoesc.crud.repositories.BestBooksRepository;

public abstract class AbstractCrudService<T extends EntidadePersistente, R extends BestBooksRepository<T>>
		implements GenericService<T> {

	private R repository;

	public AbstractCrudService(R repository) {
		this.repository = repository;
	}

	@Override
	public T salvaOuAltera(T dado) {
		return repository.save(dado);
	}

	@Override
	public T excluir(Long codigo) {
		
		T dado = this.getByCodigo(codigo);
		repository.delete(dado);
		
		return dado;
	}

	@Override
	public List<T> listar() {
		return repository.findAll();
	}

	@Override
	public T getByCodigo(Long codigo) {
		return repository.findById(codigo).get();
	}

}
