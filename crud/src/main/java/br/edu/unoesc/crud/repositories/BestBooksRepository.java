package br.edu.unoesc.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.crud.model.EntidadePersistente;

public interface BestBooksRepository<T extends EntidadePersistente> extends JpaRepository<T, Long> {

}
