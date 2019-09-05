package br.edu.unoesc.crud.repositories;

import br.edu.unoesc.crud.model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {

    Exemplar findByTitulo(String titulo);

}
