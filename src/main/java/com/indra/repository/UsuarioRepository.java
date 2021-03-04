package com.indra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.indra.model.Employees;

public interface UsuarioRepository extends Repository<Employees, Integer> {

	  List<Employees> findByLastName(String lastName);
	  
	  List<Employees> findByLastNameOrFirstName (String lastName,String firstName);
	  
	  @Query(value = "SELECT * FROM EMPLOYEES WHERE EMAIL = ?1", nativeQuery = true)
	  List<Employees> findByEmail(String email);

	  @Query(value = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME like %?1", nativeQuery = true)
	  List<Employees> findByFirstnameEndsWith(String firstname);
}