package com.indra.service;

import java.util.List;

import com.indra.model.Phone;

public interface PhoneService {
	
	List<Phone> buscar();
	
	String guardar(Phone phone);
	
	String borrar (int id);
	
	String actualizar (Phone phone, int id);

}
