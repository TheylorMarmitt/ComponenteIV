package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Permissao;
import br.edu.unoesc.crud.model.Usuario;
import br.edu.unoesc.crud.repositories.UsuarioRepository;

import static br.edu.unoesc.crud.model.Regra.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UsuarioServiceImpl extends AbstractCrudService<Usuario, UsuarioRepository> implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
    }

	@Override
	public Usuario findByPessoaEmail(String email) {
		return repository.findUsuarioByPessoaEmail(email);
	}

	@Override
	public void novoAdmin(Usuario usuario) {
		usuario.getPermissoes().add(new Permissao(ADMIN));
		this.salvaOuAltera(usuario);
		
	}

	@Override
	public void novoUsuario(Usuario usuario) {
		this.salvaOuAltera(usuario);
	}
    
    

}
