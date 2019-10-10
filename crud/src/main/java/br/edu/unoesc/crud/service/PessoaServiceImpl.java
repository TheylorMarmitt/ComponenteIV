package br.edu.unoesc.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.repositories.PessoaRepository;

@Service
public class PessoaServiceImpl extends AbstractCrudService<Pessoa, PessoaRepository> implements GenericService<Pessoa> {

	public PessoaServiceImpl(PessoaRepository repository) {
		super(repository);
	}

	@Autowired
	private PessoaRepository repository;

	@Override
	public Pessoa salvaOuAltera(Pessoa dado) {

		repository.saveAndFlush(dado);
		return dado;
	}

	public Pessoa findByEmail(String email){
		return repository.findByEmail(email);
	}

	public Integer quantidade() {
		return this.repository.findAll().size();
	}

}
