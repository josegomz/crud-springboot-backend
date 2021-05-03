package spring.mx.service;

import java.util.List;

import spring.mx.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> getAllUsuarios();
	public Usuario listarId(Long id);
	public Usuario create(Usuario usuario);
	public Usuario edit(Usuario usuario);
	public Usuario delete(Long id);

	
}
