package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Pessoa;

public interface PessoaService extends GenericService<Pessoa> {

    Pessoa findByEmail(String email);

}
