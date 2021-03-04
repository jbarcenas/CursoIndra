package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

}
