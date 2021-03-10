package com.indra.service;

import java.util.List;

import com.indra.model.Usuario;


public interface UsuarioService  {
	
     List<Usuario> buscar();
	
	String actualizar(String username,Usuario user);
		
	String borrar(Usuario user);
	
	String guardar(Usuario user);


}
