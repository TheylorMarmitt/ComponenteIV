package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Pessoa;

import java.util.List;

public interface PessoaService extends GenericService<Pessoa> {

    Pessoa findByEmail(String email);

    List<Pessoa> findByNome(String nome);
}
