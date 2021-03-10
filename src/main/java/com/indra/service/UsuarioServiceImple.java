package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Employees;
import com.indra.model.Usuario;
import com.indra.repository.UsuarioRepository;

@Service
public class UsuarioServiceImple implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public List<Usuario> buscar() {
	
		return (List<Usuario>) repo.findAll();
	}

	@Override
	public String actualizar(String username, Usuario user) {
		Optional<Usuario> encuentra = repo.findById(username);

		if(encuentra.isPresent()) {
			Usuario users = encuentra.get();
			
		        users.setNombreusuario(user.getNombreusuario());
			    users.setClave(user.getClave());
			    users.setActivo(user.getActivo());
			    users.setEmail(user.getEmail());
			    users.setTelefono(user.getTelefono());
			    
			    try {
			    	repo.save(users);
			    	return "Se realizo cambio";	
			    } catch(Exception e) {
			    	return "No se realizo el cambio";	
			    }   	
			  
			    
			}
		return "No se realizo el cambio";
	}

	@Override
	public String borrar(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Usuario user) {
		try {
			repo.save(user);
			return "Se guardo usuario";
		}catch(Exception e) {
			return "No, se guardo el usuario";
		}
		
	}

	
}
