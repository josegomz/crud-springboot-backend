package spring.mx.service;

import java.util.List;
import java.util.Optional;

import spring.mx.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> getAllUsuarios();
	public Optional<Usuario> listarId(Long id);
	public Usuario create(Usuario usuario);
	public Usuario edit(Usuario usuario);
	public void delete(Usuario usuario);

	
}
