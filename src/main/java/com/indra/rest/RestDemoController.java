package com.indra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.model.Departaments;

import com.indra.service.DepartmentsService;


@RestController
@RequestMapping("/depa")
public class RestDemoController {
	
	@Autowired
	private DepartmentsService depa;
	
	@GetMapping
	public List<Departaments> listar (){
		return depa.buscar();
	}

	@PostMapping
	public void insertar(@RequestBody Departaments dep) {
		depa.guardar(dep);
	}
}
