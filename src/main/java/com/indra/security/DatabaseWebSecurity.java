package com.indra.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity  extends WebSecurityConfigurerAdapter{
	
	

		@Autowired
	 	private DataSource dataSource;
		
		
	 	//String query="SELECT USERNAME,PASSWORD, ENABLED FROM USERS WHERE USERNAME=?";
	 	
	 	String queryAuth = "SELECT NOMBREUSUARIO, ROL FROM ROLES WHERE NOMBREUSUARIO =?";
		
		String query="SELECT NOMBREUSUARIO, CLAVE,  ACTIVO  FROM USUARIOS WHERE NOMBREUSUARIO=?";
	 	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query)
			
			 .authoritiesByUsernameQuery(queryAuth);
		
	 	}
	
}
