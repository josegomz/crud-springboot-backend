package spring.mx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mx.entity.Usuario;
import spring.mx.model.UsuarioModel;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioModel um;

	@Override
	public List<Usuario> getAllUsuarios() {
		return um.findAll();
	}

	public Usuario create(Usuario usuario) {
		return um.save(usuario);
	}
	
	public void  delete(Usuario usuario) {
		um.delete(usuario);
	}

	@Override
	public Usuario listarId(Long id) {
		return um.findById(id);
	}

	@Override
	public Usuario edit(Usuario usuario) {
		return um.save(usuario);
	}

}
