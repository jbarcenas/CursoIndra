package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "ROLES")
public class Roles {
	
	@Id
	private String nombreusuario;
	
	private String rol;

	@OneToOne
	@JoinColumn(name="NOMBREUSUARIO")
	private Usuario users;
	
	
	public Usuario getUsers() {
		return users;
	}

	public void setUsers(Usuario users) {
		this.users = users;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
