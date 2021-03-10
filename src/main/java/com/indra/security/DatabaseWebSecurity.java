package com.indra.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity  extends WebSecurityConfigurerAdapter{
	
	

		@Autowired
	 	private DataSource dataSource;
		
		

	 	@Bean
		public BCryptPasswordEncoder passswordEncoder() {
			return new BCryptPasswordEncoder();
		}
	 
	    //querys	
	 	String queryAuth = "SELECT NOMBREUSUARIO, ROL FROM ROLES WHERE NOMBREUSUARIO =?";
		
		String query="SELECT NOMBREUSUARIO, CLAVE,  ACTIVO  FROM USUARIOS WHERE NOMBREUSUARIO=?";
		
		
		
	 	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.jdbcAuthentication().dataSource(dataSource)
			 .passwordEncoder(passswordEncoder())
			.usersByUsernameQuery(query)
			 
			   .authoritiesByUsernameQuery(queryAuth);
			
			
		
	 	}
	 	
	 	
	 	@Override
	 	protected void configure (HttpSecurity http) throws Exception{
	 		http.authorizeRequests()
	 		//Recursos estaticos sin autorizacion
	 		.antMatchers("/static/**",
	 				"/imagenes/**").permitAll()
	 		
	 		//Vistas publicas sin autorizacion/autenticacion
	 		
	 		.antMatchers("/registro","/login","/guardar/user").permitAll()
	 		//URL que requieran autorizacion/autenticacion
	 		.antMatchers("/agregar/emple").hasAuthority("admin")
	 		.antMatchers("/editar/emple/**").hasAuthority("admin")
	 		.antMatchers("/borrrar/emple/**").hasAuthority("admin")
	 		.antMatchers("/guardar/emple").hasAuthority("admin")
	 		.antMatchers("/empleados").hasAnyAuthority("admin","user")
	 		.antMatchers("/usuarios").hasAuthority("admin")
	 		.antMatchers("/editar/user/**").hasAuthority("admin")
	 		.antMatchers("/update/user/**").hasAuthority("admin")
	 		
	 		
	 		.anyRequest().authenticated()
	 		 		
	 		//login sin autorizacion/autenticacion
	 		.and()
	 		.formLogin().loginPage("/login").failureUrl("/login-error")
	 		.permitAll()
	       	.and()
	       	.logout().permitAll()
	       	
	 		//.logoutSuccessUrl("/");
	      		
	 		;
	 		
	 	}
	 	
	
	 	
}
