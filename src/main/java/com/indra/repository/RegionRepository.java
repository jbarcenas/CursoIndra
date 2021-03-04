package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.model.Regions;

public interface RegionRepository extends CrudRepository<Regions, Integer> {

}
