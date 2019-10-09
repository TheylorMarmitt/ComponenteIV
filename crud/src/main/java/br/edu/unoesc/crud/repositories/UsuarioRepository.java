package br.edu.unoesc.crud.repositories;

import br.edu.unoesc.crud.model.Usuario;

public interface UsuarioRepository extends BestBooksRepository<Usuario> {

    Usuario findByEmail(String email);
}
