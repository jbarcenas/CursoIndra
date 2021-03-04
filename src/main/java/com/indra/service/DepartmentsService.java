package com.indra.service;

import java.util.List;

import com.indra.model.Departaments;


public interface DepartmentsService {
    List<Departaments> buscar();
	
	String actualizar(int id, Departaments depa);
		
	String borrar(int id);
	
	String guardar(Departaments dep);
}
