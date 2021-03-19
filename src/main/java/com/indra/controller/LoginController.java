package com.indra.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.model.Employees;
import com.indra.model.Roles;
import com.indra.model.Usuario;
import com.indra.service.RolesService;
import com.indra.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService serviceU;
	
	@Autowired 
	private RolesService serviceRol;
	
	@Autowired
	private BCryptPasswordEncoder encoderP;
	
	private List<Roles> registro = new ArrayList<Roles>();
	 
	  
	  
	  // Login form
	  @GetMapping("/login")
	  public String login(Principal principal, RedirectAttributes atribute) {
	    
		 // if(principal!=null) {
			  //atribute.addFlashAttribute("warning", "Ya has iniciado sesision");
			  //return "redirect:/empleados";
		// }
		  
		  return "login";
	  }
	  
	  
	// Login form with error
	  @GetMapping("/login-error")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }
	  
	  @GetMapping("/registro")
	  public String registrar() {
		
			
	    return "users/registro";
	  }
	
	  
		@PostMapping("/guardar/user")
		public String guardarEmple(Usuario user,RedirectAttributes atributes,Model modelo) {
			  user.setActivo(1);
			 
			  user.setClave(encoderP.encode(user.getClave()));
			  
			  Roles rols = new Roles();
			  rols.setNombreusuario(user.getNombreusuario());
			  rols.setRol("invitado");
			  user.setRoler(rols);;
			  //rols.setRol("invitado");
			  String mensajeG =serviceU.guardar(user);
			  String mensajeG2= serviceRol.guardar(rols);
			  atributes.addFlashAttribute("msj", mensajeG);

			return "redirect:/login";
		}
	  
	  

		@GetMapping("/usuarios")
		public String empleados(Model modelo) {
				
				modelo.addAttribute("users", serviceU.buscar());
				
			    return "users/usuarios";
		}
		
		
		@GetMapping("/editar/user/{username}")
		public String editarEmple(@PathVariable("username") String username, Model modelo) {
			
			for(Usuario use : serviceU.buscar()) {
		    	if(use.getNombreusuario().equals(username)) {
		    				    		
		    		modelo.addAttribute("users", use );
		    	}
		   }
			 	
		    
			
		    return "users/editar-user";
		
		}
		
		@PostMapping("/update/user/{username}")
		public String updateEmple(@PathVariable("username") String username, @RequestParam ("roles") String roles,Model model, RedirectAttributes atributes, Usuario users) {
			    //users.setClave(encoderP.encode(users.getClave()));
			    Roles rols =new Roles();
				rols.setRol(roles);
				System.out.println(users.toString());
				String mensajeG2= serviceRol.actualizar(username, rols);
			    String mensajeG = serviceU.actualizar(username, users);
				atributes.addFlashAttribute("msj", mensajeG);
			    return "redirect:/usuarios";
		 	}
		
}
