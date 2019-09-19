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
    public boolean salvar(Exemplar dado) {
        this.repository.save(dado);
        return true;
    }

    @Override
    public boolean excluir(Exemplar dado) {
        this.repository.delete(dado);
        return true;
    }

    @Override
    public List<Exemplar> listar() {
        return this.repository.findAll();
    }

    public Integer quantidade(){
        Integer qtd = 0;
        List<Exemplar> exemplares = this.repository.findAll();
        for (Exemplar e: exemplares) {
            qtd += e.getQuantidadeTotal();
        }
        return qtd;
    }

    public List<Exemplar> findDisponiveis(){
        return this.repository.findDisponiveis();
    }

    public List<Exemplar> findDisponiveisNome(String titulo){
        return this.repository.findDisponiveisTitulo(titulo);
    }



}