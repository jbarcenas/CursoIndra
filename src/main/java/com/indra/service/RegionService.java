package com.indra.service;

import java.util.List;

import com.indra.model.Regions;

public interface RegionService {
	
	List<Regions> buscar();
	
	String borrar(int id);
	
	String actualizar(Regions region, int id);
	
	String guardar(Regions region);

}