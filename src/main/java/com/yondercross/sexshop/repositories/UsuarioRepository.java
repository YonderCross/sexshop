package com.yondercross.sexshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yondercross.sexshop.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends 	CrudRepository<UsuarioModel, Long>{

}
