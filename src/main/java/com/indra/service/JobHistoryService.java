package com.indra.service;


import java.util.List;

import com.indra.identity.JobHistoryId;
import com.indra.model.JobHistory;

public interface JobHistoryService {
	List<JobHistory> buscar();
	
	String guardar(JobHistory jobH);
	
	String borrar(JobHistory jobH);
	
	String actualizar(JobHistoryId id, JobHistory jobH);
	

}
