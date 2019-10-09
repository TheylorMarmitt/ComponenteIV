package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Usuario;
import br.edu.unoesc.crud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImpl extends AbstractCrudService<Usuario, UsuarioRepository> implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
    }

    public Usuario getUsuarioPorEmail(String email){
        return repository.findByEmail(email);
    }

}
