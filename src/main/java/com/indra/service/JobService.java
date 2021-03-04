package com.indra.service;

import java.util.List;

import com.indra.model.Jobs;

public interface JobService {
	
	List<Jobs> buscar();
	
	String guardar(Jobs job);
	
	String borrar(String id);
	
	String actualizar (String id, Jobs job);
	

}
