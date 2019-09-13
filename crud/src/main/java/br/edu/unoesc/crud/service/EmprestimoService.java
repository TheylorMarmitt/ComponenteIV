package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.EmprestimoRepository;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService implements CrudService<Emprestimo> {

    @Autowired
    EmprestimoRepository repository;

    @Autowired
    ExemplarRepository exemplarRepository;

    @Override
    public boolean salvar(Emprestimo dado){

        Exemplar exemplar = exemplarRepository.findByCodigo(dado.getExemplar().getCodigo());

        if(exemplar.getQuantidadeTotal() >= dado.getQuantidade()){
            exemplar.removerQuantidade(dado.getQuantidade());
            dado.setAtivo(true);

        }else if(exemplar.getQuantidadeTotal() < dado.getQuantidade()){
            return false;
        }

        this.exemplarRepository.saveAndFlush(dado.getExemplar());
        this.repository.save(dado);
        return true;
    }

    @Override
    public boolean excluir(Emprestimo dado) {
        this.repository.delete(dado);
        return true;
    }

    @Override
    public List<Emprestimo> listar() {
        return this.repository.findAll();
    }

    public List<Exemplar> listarExemplares() {
        return this.exemplarRepository.findAll();
    }

    public Integer quantidade() {
        return this.repository.findAll().size();
    }

    public Integer quantidadeEmprestadosAtivos() {
        List<Emprestimo> emprestimos =  this.repository.findAllByAtivoTrue();
        Integer quantidade = 0;

        for (Emprestimo e: emprestimos) {
            quantidade = quantidade + e.getQuantidade();
        }
        return quantidade;
    }
}