package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Emprestimo;

import java.util.List;

public interface EmprestimoService extends GenericService<Emprestimo> {

	List<Emprestimo> listarTitulo(String titulo);
	
	List<Emprestimo> listarCliente(String nome);
	
	Integer quantidade();
	
	Integer quantidadeEmprestadosAtivos();
    
}