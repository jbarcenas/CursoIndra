package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Locations;
import com.indra.repository.LocationsRepository;

@Service
public class LocationsServiceImple implements LocationsService {

	@Autowired
	private LocationsRepository repoL;
	
	@Override
	public List<Locations> buscar() {
		/*Iterable<Locations> iter =repoL.findAll();
		for(Locations location : iter) {
	    	System.out.println(location.toString());
	    }*/
		return (List<Locations>)repoL.findAll();
	}

	@Override
	public String actualizar(int id, Locations loc) {
		Optional<Locations> encuentraId = repoL.findById(id);
		if(encuentraId.isPresent()) {
			
			Locations location= encuentraId.get();
			
			location.setStreet_address(loc.getStreet_address());
			location.setPostal_code(loc.getPostal_code());
			location.setCity(loc.getCity());
			location.setState_province(loc.getState_province());
			location.setCountry_id(loc.getCountry_id());
			
			repoL.save(location);
			return "Se actualizaron los datos correctamente";
		}
		return"No se actualizaron los datos";
	}

	@Override
	public String borrar(int id) {
		try{
			repoL.deleteById(id);
			return "Se borraron los datos correctamente";
		}catch(Exception e) {
			return "No se borraron los datos";
		}
		
		
	}

	@Override
	public String guardar(Locations location) {
		try {
			repoL.save(location);
			return "Los cambios fueron guardados correctamente";
		}catch(Exception e){
		
		return "No se insertaron los datos";
		}
	}

}
