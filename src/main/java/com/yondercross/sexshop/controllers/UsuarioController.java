package com.yondercross.sexshop.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yondercross.sexshop.services.UsuarioService;
import com.yondercross.sexshop.models.UsuarioModel;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);
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
