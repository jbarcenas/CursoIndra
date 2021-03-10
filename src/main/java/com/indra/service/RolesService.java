package com.indra.service;

import java.util.List;

import com.indra.model.Roles;



public interface RolesService {
	
	   List<Roles> buscar();
		
		String actualizar(String username,Roles rols);
			
		String borrar(Roles rols);
		
		String guardar(Roles rols);

}
