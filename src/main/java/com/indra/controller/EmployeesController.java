package com.indra.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.model.Departaments;
import com.indra.model.Employees;
import com.indra.model.Jobs;
import com.indra.model.Usuario;
import com.indra.service.DepartmentsService;
import com.indra.service.EmployeesService;
import com.indra.service.JobService;

@Controller
public class EmployeesController {

	@Autowired
	private EmployeesService serviceE;
	
	@Autowired
	private JobService serviceJ;
	
	@Autowired
	private DepartmentsService serviceD;
	
	
	private List<Employees> registroEm = new ArrayList<Employees>();
	private List<Jobs> registroJobs = new ArrayList<Jobs>();
	private List<Departaments> registroDe = new ArrayList<Departaments>();
	private final static Logger Log =  LoggerFactory.getLogger(EmployeesController.class);
	   
	
	 
	
	@GetMapping("/empleados")
	public String empleados(Model modelo) {
			registroEm = serviceE.buscar();	
			modelo.addAttribute("empleados", registroEm);
		    return "empleados";
	}
	
	@GetMapping("/agregar/emple")
	public String agregarEmple(Model modelo){
		
		registroJobs = serviceJ.buscar();
		registroDe = serviceD.buscar();
		registroEm = serviceE.buscar();
		modelo.addAttribute("jobs", registroJobs);
		modelo.addAttribute("depas", registroDe);
		modelo.addAttribute("empleado", registroEm );
		return "agregarEmple";
	}
	

	@PostMapping("/guardar/emple")
	public String guardarEmple(Employees emple ,RedirectAttributes atributes,Model modelo) {
		  String mensajeG = serviceE.guardar(emple);
		  atributes.addFlashAttribute("msj", mensajeG);

		return "redirect:/empleados";
	}
	
	@GetMapping("/borrrar/emple/{id}")
	public String borrarEmple(@PathVariable("id") int id, RedirectAttributes atributes) {
		String mensajeG = "";	
		for(Employees e : serviceE.buscar()) { 
		 	if(e.getEmployeeId()==id) {
	    		mensajeG = serviceE.borrar(e);
	    	}
	    }
		
		atributes.addFlashAttribute("msj", mensajeG).addFlashAttribute("clase", "success");
	    return "redirect:/empleados";
	}
	
	
	@GetMapping("/editar/emple/{id}")
	public String editarEmple(@PathVariable("id") int id, Model modelo) {
		registroJobs = serviceJ.buscar();
		registroDe = serviceD.buscar();
		registroEm = serviceE.buscar();
		for(Employees emple : serviceE.buscar()) {
	    	if(emple.getEmployeeId()==id) {
	    		modelo.addAttribute("emple", emple);
	    		modelo.addAttribute("jobs", registroJobs);
	    		modelo.addAttribute("depas", registroDe);
	    		modelo.addAttribute("empleado", registroEm );
	    	}
	   }
		
	    return "editar-emple";
	
	}
	
	@PostMapping("/update/{id}")
	public String updateEmple(@PathVariable("id") int id, Model model, RedirectAttributes atributes,Employees emple) {
		 	String mensajeG = serviceE.actualizar(id, emple);
			atributes.addFlashAttribute("msj", mensajeG);
		    return "redirect:/empleados";
	 	}
	
	
	@GetMapping("/detalles/emple/{id}")
	public String detallesEmple(@PathVariable("id") int id, Model modelo) {
		registroJobs = serviceJ.buscar();
		registroDe = serviceD.buscar();
		registroEm = serviceE.buscar();
		for(Employees emple : serviceE.buscar()) {
	    	if(emple.getEmployeeId()==id) {
	    		modelo.addAttribute("emple", emple);
	    		modelo.addAttribute("jobs", registroJobs);
	    		modelo.addAttribute("depas", registroDe);
	    		modelo.addAttribute("empleado", registroEm );
	    	}
	   }
		
	    return "empleDetalles";
	
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){		
          	SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(formatoFecha,false));
        
	}	

}
