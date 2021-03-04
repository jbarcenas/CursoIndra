package com.indra.service;
import java.util.List;

import com.indra.model.Employees;


public interface EmployeesService {
	
	List<Employees> buscar();
	
	String actualizar(int id,Employees emp);
		
	String borrar(Employees emple);
	
	String guardar(Employees emple);
	
	
	
}
