package br.edu.unoesc.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.edu.unoesc.crud.model.EntidadePersistente;

@NoRepositoryBean
public interface BestBooksRepository<T extends EntidadePersistente> extends JpaRepository<T, Long> {

}
