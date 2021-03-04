package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.identity.JobHistoryId;
import com.indra.model.JobHistory;

public interface JobsHistoryRepository extends CrudRepository<JobHistory, JobHistoryId> {

}
