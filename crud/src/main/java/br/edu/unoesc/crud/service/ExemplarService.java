package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplarService implements CrudService<Exemplar> {

    @Autowired
    ExemplarRepository repository;

    @Override
    public void salvar(Exemplar dado) {
        this.repository.save(dado);
    }

    @Override
    public void excluir(Exemplar dado) {
        this.repository.delete(dado);
    }

    @Override
    public List<Exemplar> listar() {
        return this.repository.findAll();
    }




}