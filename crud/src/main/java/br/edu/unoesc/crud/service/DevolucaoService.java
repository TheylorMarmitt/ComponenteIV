package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Devolucao;
import br.edu.unoesc.crud.repositories.DevolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DevolucaoService implements CrudService<Devolucao>{

    @Autowired
    DevolucaoRepository repository;

    @Override
    public boolean salvar(Devolucao dado) {
        return false;
    }

    @Override
    public boolean excluir(Devolucao dado) {
        return false;
    }

    @Override
    public List<Devolucao> listar() {
        return null;
    }
}
