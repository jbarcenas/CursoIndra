package com.indra.service;

import java.util.List;

import com.indra.model.Locations;



public interface LocationsService {
	    List<Locations> buscar();
		
		String actualizar(int id, Locations location);
			
		String borrar(int id);
		
		String guardar(Locations location);
}
