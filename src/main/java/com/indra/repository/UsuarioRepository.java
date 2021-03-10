package com.indra.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.indra.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	
	  
	 /* List<Employees> findByLastNameOrFirstName (String lastName,String firstName);
	  
	  @Query(value = "SELECT * FROM EMPLOYEES WHERE EMAIL = ?1", nativeQuery = true)
	  List<Employees> findByEmail(String email);

	  @Query(value = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME like %?1", nativeQuery = true)
	  List<Employees> findByFirstnameEndsWith(String firstname);*/
	
	//
      // @Query(value= "SELECT NOMBREUSUARIO, ROL FROM ROLES WHERE NOMBREUSUARIO =?", nativeQuery =true)
       
       //List<Usuario> findByNombreusuario(String nombreusuario);
	
      // List<Usuario> findByUser(String nombreusuario);
}