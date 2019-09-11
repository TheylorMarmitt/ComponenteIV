package br.edu.unoesc.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.repositories.PessoaRepository;

@Service
public class PessoaService implements CrudService<Pessoa> {

	@Autowired
	private PessoaRepository repository;
	
	@Override
	public Pessoa salvar(Pessoa dado) {
			repository.save(dado);
	}

	@Override
	public Pessoa excluir(Pessoa dado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
