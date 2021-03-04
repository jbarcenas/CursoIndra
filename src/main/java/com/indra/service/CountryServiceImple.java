package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Countries;
import com.indra.repository.CountriesRepository;
@Service
public class CountryServiceImple implements CountryService {

	@Autowired
	private CountriesRepository repo;
	
	@Override
	public List<Countries> buscar() {
		/*Iterable<Countries> iter = repo.findAll();
		for(Countries country: iter) {
			System.out.println(country.toString());
		}*/
		return (List<Countries>)repo.findAll();
	}

	@Override
	public String guardar(Countries country) {
		 Optional<Countries> encuentra = repo.findById(country.getCountry_id());
			
			if(!encuentra.isPresent()) {
				repo.save(country);
				return "Se guardaron los datos correctamente";
			}

		return "No se guardaron los datos";
	}

	@Override
	public String borrar(String id) {
		try {
			repo.deleteById(id);
			return "Se borraron los datos correctamente";
		}catch(Exception e) {
			return "No se borraron los datos";
		}
	}

	@Override
	public String actualizar(Countries country, String id) {
        Optional<Countries> encuentra = repo.findById(id);
		
		if(encuentra.isPresent()) {
			Countries countri = encuentra.get();
			
			countri.setCountry_name(country.getCountry_name());
			countri.setRegion_id(country.getRegion_id());
			repo.save(countri);
			return "Se actualizaron los datos correctamente";
		}
		
		return "No se actualizaron los datos";
		
	}

}
