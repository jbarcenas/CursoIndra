package com.indra.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="JOBS")
public class Jobs {
	
	@Id
	private String job_id;
	private String job_title;
	private Integer min_salary;
	private Integer max_salary;
	
	
	
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public Integer getMin_salary() {
		return min_salary;
	}
	public void setMin_salary(Integer min_salary) {
		this.min_salary = min_salary;
	}
	public Integer getMax_salary() {
		return max_salary;
	}
	public void setMax_salary(Integer max_salary) {
		this.max_salary = max_salary;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	
	
	@Override
	public String toString() {
		return "Jobs [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + ", getJob_id()=" + getJob_id() + ", getMin_salary()=" + getMin_salary()
				+ ", getMax_salary()=" + getMax_salary() + ", getJob_title()=" + getJob_title() + "]";
	}
	
	
	
	
	
	
}