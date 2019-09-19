package br.edu.unoesc.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.repositories.PessoaRepository;

@Service
public class PessoaService implements CrudService<Pessoa> {

	@Autowired
	private PessoaRepository repository;
	
	@Override
	public boolean salvar(Pessoa dado) {
		repository.save(dado);
		return true;
	}

	@Override
	public boolean excluir(Pessoa dado) {
		repository.delete(dado);
		return true;
	}

	@Override
	public List<Pessoa> listar() {
		return repository.findAll();
	}

	public Integer quantidade(){
		return this.repository.findAll().size();
	}
	
	public Optional<Pessoa> getByCodigo(Long codigo) {
		return repository.findById(codigo);
	}


}
