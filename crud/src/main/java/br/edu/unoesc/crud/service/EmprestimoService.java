package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.exception.BestBooksException;
import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.repositories.EmprestimoRepository;
import br.edu.unoesc.crud.repositories.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmprestimoService implements CrudService<Emprestimo> {

    @Autowired
   private EmprestimoRepository repository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    @Override
    @Transactional
    public Emprestimo salvaOuAltera(Emprestimo dado)  {
        dado.setExemplar(exemplarRepository.findByCodigo(dado.getExemplar().getCodigo()));
        dado = ajusteQtd(dado);

        this.repository.save(dado);
        return dado;
    }

    @Override
    public Emprestimo excluir(Emprestimo dado) {
        this.repository.delete(dado);
        return dado;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Emprestimo> listar() {
        List<Emprestimo> lista = this.repository.findAllByAtivoTrue();

        return filtrar(lista);
    }

    @Transactional(readOnly = true)
    public List<Emprestimo> listarTitulo(String titulo) {
        List<Emprestimo> lista = this.repository.findByExemplarTituloAndAtivoTrue(titulo);

        return filtrar(lista);
    }

    @Transactional(readOnly = true)
    public List<Emprestimo> listarCliente(String nome) {
        List<Emprestimo> lista = this.repository.findByPessoaNomeAndAtivoTrue(nome);

        return filtrar(lista);
    }

    public List<Exemplar> listarExemplares() {
        return this.exemplarRepository.findDisponiveis();
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

    private Emprestimo ajusteQtd(Emprestimo dado) {

        if(dado.getExemplar().getQuantidadeTotal() >= dado.getQuantidade()){
            dado.getExemplar().removerQuantidade(dado.getQuantidade());
            dado.setAtivo(true);

        }else{
            throw new BestBooksException("Exemplar não pode ser nulo");
        }
        this.exemplarRepository.saveAndFlush(dado.getExemplar());
        return dado;
    }

    private List<Emprestimo> filtrar(List<Emprestimo> lista){
        for (int i = 0; i < lista.size(); i++ ) {
            Pessoa p = lista.get(i).getPessoa();
            lista.get(i).getPessoa().setCodigo(p.getCodigo());
            lista.get(i).getPessoa().setNome(p.getNome());
        }
        return lista;
    }

    public Emprestimo getByCodigo(Long codigo){
        return repository.findByCodigo(codigo);
    }

}