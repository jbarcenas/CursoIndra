package com.indra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.indra.model.Departaments;
import com.indra.service.DepartmentsService;

@Controller
public class DepartmentsController {
	
	@Autowired
	private DepartmentsService serviceD;
	
	private List<Departaments> registro = new ArrayList<Departaments>();
	
	@GetMapping("/departamentos")
	public String departamentos(Model modelo) {
		//if(serviceD.buscar()!= null) {
		registro = serviceD.buscar();
		modelo.addAttribute("depas", registro);
		return "departamentos";
	}
	
	

}
