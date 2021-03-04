package com.indra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.indra.model.Countries;
import com.indra.service.CountryService;

@Controller
public class CountriesController {
	
	@Autowired
	private CountryService serviceC;
	
	private List<Countries> registro = new ArrayList<Countries>();
	
	@GetMapping("/countries")
	public String countries(Model modelo) {
		registro = serviceC.buscar(); 
		modelo.addAttribute("countrie",registro);
		return "countries";
	}

}
