package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "USUARIOS")
public class Usuario {
		
		@Id
		private String nombreusuario;
		
		private String clave;
		
		private String email;
		
		private String telefono;
		
		private int activo;

		public String getNombreusuario() {
			return nombreusuario;
		}

		public void setNombreusuario(String nombreusuario) {
			this.nombreusuario = nombreusuario;
		}

		public String getClave() {
			return clave;
		}

		public void setClave(String clave) {
			this.clave = clave;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public int getActivo() {
			return activo;
		}

		public void setActivo(int activo) {
			this.activo = activo;
		}

		@Override
		public String toString() {
			return "Usuario [nombreusuario=" + nombreusuario + ", clave=" + clave + ", email=" + email + ", telefono="
					+ telefono + ", activo=" + activo + ", getNombreusuario()=" + getNombreusuario() + ", getClave()="
					+ getClave() + ", getEmail()=" + getEmail() + ", getTelefono()=" + getTelefono() + ", getActivo()="
					+ getActivo() + "]";
		}

		

		
		
}
