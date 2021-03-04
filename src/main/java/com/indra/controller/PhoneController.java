package com.indra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.indra.model.Phone;
import com.indra.service.PhoneService;

@Controller
public class PhoneController {

	@Autowired
	private PhoneService serviceP;
	
	private List<Phone> registro = new ArrayList<Phone>();
	
	
	@GetMapping("/phones")
	public String phones(Model modelo) {
		registro= serviceP.buscar();
		modelo.addAttribute("phone", registro);
		return "phones";
	}
	
}
