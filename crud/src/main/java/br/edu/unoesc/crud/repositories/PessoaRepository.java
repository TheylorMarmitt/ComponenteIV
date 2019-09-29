package br.edu.unoesc.crud.repositories;

import br.edu.unoesc.crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends BestBooksRepository<Pessoa> {

    Pessoa findByEmail(String email);
}
