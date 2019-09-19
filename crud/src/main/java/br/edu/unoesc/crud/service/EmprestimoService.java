package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.repositories.EmprestimoRepository;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmprestimoService implements CrudService<Emprestimo> {

    @Autowired
    EmprestimoRepository repository;

    @Autowired
    ExemplarRepository exemplarRepository;

    @Override
    @Transactional
    public boolean salvar(Emprestimo dado) throws Exception {
        dado.setExemplar(exemplarRepository.findByCodigo(dado.getExemplar().getCodigo()));
        dado = ajusteQtd(dado);

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

    private Emprestimo ajusteQtd(Emprestimo dado) throws Exception {

        if(dado.getExemplar().getQuantidadeTotal() >= dado.getQuantidade()){
            dado.getExemplar().removerQuantidade(dado.getQuantidade());
            dado.setAtivo(true);

        }else{
            throw new Exception("Exemplar não pode ser nulo");
        }
        this.exemplarRepository.saveAndFlush(dado.getExemplar());
        return dado;
    }
}