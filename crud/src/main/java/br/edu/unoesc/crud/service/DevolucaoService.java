package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Devolucao;
import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.DevolucaoRepository;
import br.edu.unoesc.crud.repositories.EmprestimoRepository;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DevolucaoService implements CrudService<Devolucao> {

	@Autowired
	private DevolucaoRepository repository;

	@Autowired
	private ExemplarRepository exemplarRepository;

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Override
	@Transactional
	public Devolucao salvaOuAltera(Devolucao dado) throws Exception {

		dado.setEmprestimo(emprestimoRepository.findByCodigo(dado.getEmprestimo().getCodigo()));
		dado.getEmprestimo()
				.setExemplar(exemplarRepository.findByCodigo(dado.getEmprestimo().getExemplar().getCodigo()));

		dado = ajustes(dado);

		this.repository.save(dado);
		return dado;
	}

	@Override
	public Devolucao excluir(Devolucao dado) {
		return dado;
	}

	@Override
	public List<Devolucao> listar() {
		return null;
	}

	private Devolucao ajustes(Devolucao d) throws Exception {
		if (d.getQuantidade() <= d.getEmprestimo().getQuantidade()) {
			d.getEmprestimo().setQuantidade(d.getEmprestimo().getQuantidade() - d.getQuantidade());

			if (d.getEmprestimo().getQuantidade() == 0) {
				d.getEmprestimo().setAtivo(false);
			}
			d.getEmprestimo().getExemplar().addQuantidade(d.getQuantidade());

		} else {
			throw new Exception("Quantidade de devolução maior que emprestados");
		}
		this.emprestimoRepository.saveAndFlush(d.getEmprestimo());
		this.exemplarRepository.saveAndFlush(d.getEmprestimo().getExemplar());
		return d;
	}

}
