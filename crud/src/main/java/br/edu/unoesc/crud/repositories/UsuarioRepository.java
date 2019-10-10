package br.edu.unoesc.crud.repositories;

import org.springframework.data.jpa.repository.Query;

import br.edu.unoesc.crud.model.Usuario;

public interface UsuarioRepository extends BestBooksRepository<Usuario> {
	
	@Query("select u from Usuario u join fetch u.permissoes where u.email = ?1")
    Usuario findByEmail(String email);
}
