package br.edu.unoesc.crud.repositories;

import br.edu.unoesc.crud.model.Emprestimo;
import br.edu.unoesc.crud.model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findByAtivoTrueAndPessoaCodigo(long codigo);

    Emprestimo findByCodigo(long codigo);

    List<Emprestimo> findAllByAtivoTrue();

    List<Emprestimo> findByExemplarTituloAndAtivoTrue(String titulo);

    List<Emprestimo> findByPessoaNomeAndAtivoTrue(String nome);

}
