package spring.mx.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import spring.mx.entity.Usuario;
import spring.mx.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200" , maxAge= 3600)
@RestController
@RequestMapping({"/usuario"})
public class UsuarioController {
	
	@Autowired
	public UsuarioService us;

	//muestra la lista de usuarios
	
	@GetMapping("/listarUsuarios")
	public List<Usuario> listarUsuarios() {
		 return us.getAllUsuarios(); 
	}
	
	@PostMapping("/agregarUsuario")
	public Usuario guardarUsuario( @RequestBody Usuario usuario) {
			return us.create(usuario);
	}

	@GetMapping(path={"/{id}"})
	public Usuario listarId(@PathVariable("id") Long id ){
		System.out.println("El id del usuario es: "+id);
		return us.listarId(id);

	}
	
	@PutMapping(path={"/{id}"})
	public Usuario editarUsuario(@RequestBody Usuario usuario, @PathVariable("id") Long id ){
		usuario.setId(id);
		return us.edit(usuario);
	}
}
