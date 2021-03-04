package com.indra.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.identity.JobHistoryId;
import com.indra.model.JobHistory;

import com.indra.repository.JobsHistoryRepository;

@Service
public class JobHistoryServiceImple implements JobHistoryService {

	@Autowired
	private JobsHistoryRepository repo;
	
	@Override
	public List<JobHistory> buscar() {
		/*Iterable<JobHistory> iter = repo.findAll();
		for(JobHistory jobH: iter) {
			System.out.println(jobH.toString());
		}*/
		return (List<JobHistory>)repo.findAll();
	}

	@Override
	public String guardar(JobHistory jobH) {
	
		try {	 
			 
			 repo.save(jobH);
			 return "Se guardaron los datos correctamente";
		 }catch(Exception e) {
			
		     return "No se guardaron los datos";
		 }

		
	}

	@Override
	public String borrar(JobHistory job) {
		try {
			repo.delete(job);
			return "Se borraron los datos correctamente";
		}catch(Exception e) {
			return "No se borraron los datos";
		}
	}

	@Override
	public String actualizar(JobHistoryId id, JobHistory jobH) {
		Optional<JobHistory> encuentra = repo.findById(id);
		if(encuentra.isPresent()) {
			JobHistory jobHistory = encuentra.get();
			jobHistory.setJob_id(jobH.getJob_id());
			jobHistory.setDepartment_id(jobH.getDepartment_id());
			jobHistory.setEnd_date(jobH.getEnd_date());
			
			repo.save(jobHistory);
			return "Se modificaron los datos correctamente";
		}
		return "No se modificaron los datos";
	}

}
