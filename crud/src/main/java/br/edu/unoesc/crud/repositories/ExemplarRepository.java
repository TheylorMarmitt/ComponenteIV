package br.edu.unoesc.crud.repositories;

import br.edu.unoesc.crud.model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {

    Exemplar findByTitulo(String titulo);

    Exemplar findByCodigo(long codigo);

    @Query("select e from Exemplar e where e.quantidadeTotal > 0")
    List<Exemplar> findDisponiveis();

    @Query("select e from Exemplar e where e.quantidadeTotal > 0 and e.titulo = ?1")
    List<Exemplar> findDisponiveisTitulo(String titulo);
}
