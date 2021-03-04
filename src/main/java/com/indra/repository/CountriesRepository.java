package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.model.Countries;
import com.indra.model.Regions;

public interface CountriesRepository extends CrudRepository<Countries, String> {

	void save(Regions region);

}
