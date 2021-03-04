package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Phone;
import com.indra.repository.PhoneRepository;


@Service
public class PhoneServiceImple implements PhoneService {

	@Autowired
	private PhoneRepository repo;
	
	@Override
	public List<Phone> buscar() {
		/*Iterable<Phone> iter = repo.findAll();
		for(Phone phone: iter) {
			System.out.println(phone.toString());
		}*/
		return (List<Phone>)repo.findAll();
	}

	@Override
	public String guardar(Phone phone) {
		try {
			repo.save(phone);
			return "Se guardaron los cambios correctamente";
		}catch(Exception e) {
			return "No se guardaron los datos";
		}
	}

	@Override
	public String borrar(int id) {
		try {
			repo.deleteById(id);
			return "Se borraron los datos correctamente";
		}catch(Exception e ) {
			return "No se borraron los datos";
		}
	}

	@Override
	public String actualizar(Phone phone, int id) {
		Optional<Phone> encuentra = repo.findById(id);
		
		if(encuentra.isPresent()) {
			Phone phones = encuentra.get();
			
			phones.setExtension(phone.getExtension());
			phones.setIsd_code(phone.getIsd_code());
			phones.setPhone_number(phone.getPhone_number());
			phones.setType(phone.getType());
			phones.setEmployee_id(phone.getEmployee_id());
			repo.save(phones);
			
			return "Se actualizaron los datos correctamente";			
		}
		
		return "No se realizaron los cambios";
		
	 }

}
