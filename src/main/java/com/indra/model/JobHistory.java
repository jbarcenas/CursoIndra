package com.indra.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.indra.identity.JobHistoryId;

@Entity
@Table(name="JOB_HISTORY")
public class JobHistory {
	
	@EmbeddedId
	private JobHistoryId id;
	
	private Date end_date;
	private String job_id;
	private Integer department_id;
	
	
	@ManyToOne
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, updatable=false, insertable=false)
    private Employees employes;
	
	public JobHistoryId getId() {
		return id;
	}
	public void setId(JobHistoryId id) {
		this.id = id;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	
	@Override
	public String toString() {
		return "JobHistory [id=" + id + ", end_date=" + end_date + ", job_id=" + job_id + ", department_id="
				+ department_id + ", employes=" + employes + ", getId()=" + getId() + ", getEnd_date()=" + getEnd_date()
				+ ", getJob_id()=" + getJob_id() + ", getDepartment_id()=" + getDepartment_id() + "]";
	}
	
	
	
	
	
	
	
	
	

}
