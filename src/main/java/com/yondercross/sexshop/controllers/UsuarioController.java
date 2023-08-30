package com.yondercross.sexshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yondercross.sexshop.services.UsuarioService;
import com.yondercross.sexshop.models.UsuarioModel;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public List<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);
	}
	
	@PutMapping(path= "/{id}")
	public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel usuario, @PathVariable("id") Long id) {
		return this.usuarioService.actualizarUsuario(usuario, id);
	}

	@GetMapping(path="/{id}")
	public Optional<UsuarioModel> obetenerUsuarioPorId(@PathVariable("id") long id){
		return this.usuarioService.obtenerporId(id);
	}
	
	@DeleteMapping(path="/{id}")
	public String eliminarPorId(@PathVariable("id") long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if (ok) {
			return "Se elimino el usuario con id " + id;
		}
		else {
			return "No se pudo eliminar el usuario con id " + id;		}
	}
	
	
}
