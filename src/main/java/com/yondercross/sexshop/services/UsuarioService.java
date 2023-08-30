package com.yondercross.sexshop.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yondercross.sexshop.models.UsuarioModel;
import com.yondercross.sexshop.repositories.UsuarioRepository;

@Service
public class UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	//Get 
	public List<UsuarioModel> obtenerUsuarios(){
		return (List<UsuarioModel>) usuarioRepository.findAll();
	}
	
	//POST
	public UsuarioModel guardarUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//PUT
	public UsuarioModel actualizarUsuario(UsuarioModel usuario, Long id) {
		UsuarioModel usuarioRet = usuarioRepository.findById(id).get();
		
		//Actualiza Nombre
		if (Objects.nonNull(usuario.getNombre()) && !"".equalsIgnoreCase(usuario.getNombre())) {
			usuarioRet.setNombre(usuario.getNombre());
		}
		
		//Actualiza apellido1
		if (Objects.nonNull(usuario.getApellido1()) && !"".equalsIgnoreCase(usuario.getApellido1())) {
			usuarioRet.setApellido1(usuario.getApellido1());
		}
		
		//Actualiza apellido2
		if (Objects.nonNull(usuario.getApellido2()) && !"".equalsIgnoreCase(usuario.getApellido2())) {
			usuarioRet.setApellido2(usuario.getApellido2());
		}
		
		//Actualiza correo
		if (Objects.nonNull(usuario.getCorreo()) && !"".equalsIgnoreCase(usuario.getCorreo())) {
			usuarioRet.setCorreo(usuario.getCorreo());
		}
		
		//Actualiza telefono
		if (Objects.nonNull(usuario.getTelefono()) && !"".equalsIgnoreCase(usuario.getTelefono())) {
			usuarioRet.setTelefono(usuario.getTelefono());
		}
		
		//Actualiza direccion
		if (Objects.nonNull(usuario.getDireccion()) && !"".equalsIgnoreCase(usuario.getDireccion())) {
			usuarioRet.setDireccion(usuario.getDireccion());
		}
		
		//Actualiza contraseña
		if (Objects.nonNull(usuario.getContrasena()) && !"".equalsIgnoreCase(usuario.getContrasena())) {
			usuarioRet.setContrasena(usuario.getContrasena());
		}
		
		return usuarioRepository.save(usuarioRet);
	}
	
	//GET ID
	public Optional<UsuarioModel> obtenerporId(Long id){
		return usuarioRepository.findById(id);
	}
	
	//DELETE
	public boolean eliminarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}
		catch(Exception err){
			return false;
		}
	}
	
	
	
}
	
