package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indra.model.Employees;
import com.indra.repository.EmployeesRepository;
@Service
public class EmployeesServiceImple implements EmployeesService {

	@Autowired
	private EmployeesRepository repoE;
	

	
	@Override
	public List<Employees> buscar() {
		return (List<Employees>)repoE.findAll();
	}

	
	
	@Override
	public String actualizar(int id, Employees emp) {
        Optional<Employees> encuentra = repoE.findById(id);
        Iterable<Employees> iter =repoE.findAll();
		if(encuentra.isPresent()) {
			Employees emple = encuentra.get();
			for(Employees e : iter) {
		    	if(e.getEmail().equals(emp.getEmail())){
		    		return "No se realizo cambio porque ya existe un correo igual";
		    	}
		    }
			    emple.setFirstName(emp.getFirstName());
			    emple.setLastName(emp.getLastName());
			   
			    emple.setPhoneNumber(emp.getPhoneNumber());
			    emple.setHireDate(emp.getHireDate());
			    emple.setJobs(emp.getJobs());
			    emple.setSalary(emp.getSalary());
			    emple.setCommissionPct(emp.getCommissionPct());
			    emple.setManagerId(emp.getManagerId());
			    emple.setDepas(emp.getDepas());
			    emple.setEmail(emp.getEmail());
			    
			    try {
			    	repoE.save(emple);
			    	return "Se realizo cambio";	
			    } catch(Exception e) {
			    	return "No se realizo el cambio";	
			    }   	
			  
			    
			}
		return "No se realizo el cambio";	
	}
	
	

	@Override
	public String borrar(Employees em) {
		try {	
		    repoE.delete(em);
		    return "Se borraron los datos correctamente";
		}catch(Exception e){
			
			return "No se borro el registro, verifique que no sea un administrador";
			}
	 }


	@Override
	public String guardar(Employees emple) {
			try {
				repoE.save(emple);
				return "Los cambios fueron guardados correctamente";
			}catch(Exception e){
			
			return "No se inserto el registro, verifique que el correo este bien";
			}
	}

	
}
