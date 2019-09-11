package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.EmprestimoRepository;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService implements CrudService<Emprestimo> {

    @Autowired
    EmprestimoRepository repository;

    @Autowired
    ExemplarRepository exemplarRepository;

    @Override
    public void salvar(Emprestimo dado) {
        this.repository.save(dado);
    }

    @Override
    public void excluir(Emprestimo dado) {
        this.repository.delete(dado);
    }

    @Override
    public List<Emprestimo> listar() {
        return this.repository.findAll();
    }

    public List<Exemplar> listarExemplares() {
        return this.exemplarRepository.findAll();
    }




}