package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.repositories.EmprestimoRepository;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmprestimoService extends GenericService<Emprestimo> {

	List<Emprestimo> listarTitulo(String titulo);
	
	List<Emprestimo> listarCliente(String nome);
	
	Integer quantidade();
	
	Integer quantidadeEmprestadosAtivos();
    
}