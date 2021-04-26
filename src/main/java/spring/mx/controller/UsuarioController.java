package spring.mx.controller;

import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String saveUsuario(@RequestParam(name="file",required = false) MultipartFile foto, Usuario usuario) {
		if(!foto.isEmpty()) {
		
			Path DirectorioImagenes = Paths.get("src","main","resources","static","img","usuario");
			String RutaIMG = DirectorioImagenes.toFile().getAbsolutePath();
			//guardar imagen
			try {
				byte[] byteIMG = foto.getBytes();
				String RutaAbsoluta = Paths.get(RutaIMG+"/"+foto.getOriginalFilename()).toString();
				File dir = new File(RutaIMG);
				if(!dir.exists()) {
					System.out.println("Archivo creado");
					dir.mkdirs();					
				}else {
					System.out.println("Archivo existe");
				}
				System.out.println(RutaAbsoluta);
				//guardar el documento
				BufferedOutputStream  stream = new BufferedOutputStream(new FileOutputStream(RutaAbsoluta));
				stream.write(byteIMG);
				stream.close();
				usuario.setImagen(foto.getOriginalFilename());
			}catch(Exception e) {
				e.getMessage();
			}
			us.create(usuario);
		}
		return("redirect:/");
	}

}
