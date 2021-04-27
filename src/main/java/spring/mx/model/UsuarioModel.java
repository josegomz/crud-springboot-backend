package spring.mx.model;

import java.util.List;
import org.springframework.data.repository.Repository;

import spring.mx.entity.Usuario;

public interface UsuarioModel extends Repository<Usuario, Long>{
	List<Usuario> findAll();
	Usuario findById(Long id);
	Usuario save(Usuario usuario);
	void delete(Usuario usuario);
}
