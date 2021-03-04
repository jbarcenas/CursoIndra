package com.indra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Jobs;
import com.indra.repository.JobsRepository;
@Service
public class JobServiceImple implements JobService {
 
	@Autowired
	private JobsRepository repo;
	
	@Override
	public List<Jobs> buscar() {
		/*Iterable<Jobs> iter = repo.findAll();
		for(Jobs job: iter) {
			System.out.println(job.toString());
		}*/
		return (List<Jobs>)repo.findAll();
	}

	@Override
	public String guardar(Jobs job) {
      Optional<Jobs> encuentra = repo.findById(job.getJob_id());
		
		if(!encuentra.isPresent()) {
			repo.save(job);
			return "Se guardaron los datos correctamente";
		}

	return "No se guardaron los datos";
		
	}

	@Override
	public String borrar(String id) {
		try {
			repo.deleteById(id);
			return "Se borraron los datos correctamente";
		}catch(Exception e) {
			return "No se borraron los datos";
		}
	}

	@Override
	public String actualizar(String id, Jobs job) {
		Optional<Jobs> encuentra = repo.findById(id);
		
		if(encuentra.isPresent()) {
			Jobs jobs = encuentra.get();
			
			jobs.setJob_title(job.getJob_title());
			jobs.setMax_salary(job.getMax_salary());
			jobs.setMin_salary(job.getMin_salary());
			
			repo.save(jobs);
			return "Se actualizaron los datos correctamente";
		}
		
		return "No se actualizaron los datos";
		
	}

}
