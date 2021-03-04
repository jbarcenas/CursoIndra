package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Departaments;
import com.indra.repository.DepartamentsRepostitory;

@Service
public class DepartamentsServiceImple implements DepartmentsService {

	@Autowired
	private DepartamentsRepostitory repoD;
	
	@Override
	public List<Departaments> buscar() {
		//Iterable<Departaments> iter = repoD.findAll();
		/*for(Departaments dep : iter) {
	    	System.out.println(dep.toString());
	    }*/
		return (List<Departaments>)repoD.findAll();
	
	}

	
	@Override
	public String actualizar(int id,Departaments depa) {
		 Optional<Departaments> encuentra = repoD.findById(id);
			
			if(encuentra.isPresent()) {
				Departaments dep = encuentra.get();
				dep.setLocation_id(depa.getLocation_id());
				dep.setManager_id(depa.getManager_id());
				dep.setDepartment_name(depa.getDepartment_name());		
				repoD.save(dep);
				
				return "Los cambios fueron actualizados correctamente";
			}
			
			return "No se realizo el cambio";
	}

	
	@Override
	public String borrar(int id) {
		try {
			repoD.deleteById(id);
				return "Se borraron los datos correctamente";
		}catch(Exception e){
		
		return "No se borraron los datos";
		}
	}

	
	@Override
	public String guardar(Departaments dep) {
		try {
			repoD.save(dep);
			
			return "Los cambios fueron guardados correctamente";
		}catch(Exception e){
		
		return "No se insertaron los datos";
		}
	}

}
