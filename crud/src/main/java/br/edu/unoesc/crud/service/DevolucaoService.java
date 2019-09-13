package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Devolucao;
import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.DevolucaoRepository;
import br.edu.unoesc.crud.repositories.EmprestimoRepository;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DevolucaoService implements CrudService<Devolucao>{

    @Autowired
    DevolucaoRepository repository;

    @Autowired
    ExemplarRepository exemplarRepository;

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Override
    public boolean salvar(Devolucao dado) {

        Emprestimo emprestimo = emprestimoRepository.findByCodigo(dado.getEmprestimo().getCodigo());
        Exemplar exemplar = exemplarRepository.findByCodigo(dado.getEmprestimo().getExemplar().getCodigo());

        emprestimo.setQuantidade(emprestimo.getQuantidade() - dado.getQuantidade());

        if(emprestimo.getQuantidade() == 0){
            emprestimo.setAtivo(false);
            return true;
        }
        exemplar.addQuantidade(dado.getQuantidade());

        this.emprestimoRepository.saveAndFlush(emprestimo);
        this.exemplarRepository.saveAndFlush(exemplar);
        this.repository.save(dado);
        return true;
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
