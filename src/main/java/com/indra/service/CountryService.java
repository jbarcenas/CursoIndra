package com.indra.service;

import java.util.List;

import com.indra.model.Countries;

public interface CountryService {
	List<Countries> buscar();
	
	String guardar (Countries country);
	
	String borrar (String id);
	
	String actualizar (Countries country, String id);
	
	
	
}
