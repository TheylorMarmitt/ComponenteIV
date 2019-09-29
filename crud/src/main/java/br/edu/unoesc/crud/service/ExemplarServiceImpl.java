package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplarServiceImpl extends AbstractCrudService<Exemplar, ExemplarRepository> implements ExemplarService {

	public ExemplarServiceImpl(ExemplarRepository repository) {
		super(repository);
	}

	@Autowired
	private ExemplarRepository repository;

	@Override
	public Exemplar salvaOuAltera(Exemplar dado) {
		this.repository.save(dado);
		return dado;
	}


	@Override
	public List<Exemplar> listar() {
		return this.repository.findAll();
	}

	public Integer quantidade() {
		Integer qtd = 0;
		List<Exemplar> exemplares = this.repository.findAll();
		for (Exemplar e : exemplares) {
			qtd += e.getQuantidadeTotal();
		}
		return qtd;
	}

	public List<Exemplar> findDisponiveis() {
		return this.repository.findDisponiveis();
	}

	public List<Exemplar> findDisponiveisNome(String titulo) {
		return this.repository.findDisponiveisTitulo(titulo);
	}

}