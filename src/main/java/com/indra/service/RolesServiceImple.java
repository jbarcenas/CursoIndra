package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Roles;
import com.indra.model.Usuario;
import com.indra.repository.RolesRepository;

@Service
public class RolesServiceImple implements RolesService{
	@Autowired
	private RolesRepository repo;

	@Override
	public List<Roles> buscar() {
		
		return (List<Roles>) repo.findAll();
	}

	@Override
	public String actualizar(String username, Roles rols) {
		Optional<Roles> encuentra = repo.findById(username);

		if(encuentra.isPresent()) {
			Roles rolss = encuentra.get();
			
		        rolss.setRol(rols.getRol());
			    
			    try {
			    	repo.save(rolss);
			    	return "Se realizo cambio";	
			    } catch(Exception e) {
			    	return "No se realizo el cambio";	
			    }   	
			  
			    
			}
		return "No se realizo el cambio";
	}

	@Override
	public String borrar(Roles rols) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Roles rols) {
		try {
			repo.save(rols);
			return "Se guardo el rol";
		}catch(Exception e) {
			return "No, se guardo el rol";
		}
		
	}
	

}
