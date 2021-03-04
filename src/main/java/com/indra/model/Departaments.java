package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Departaments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
	@SequenceGenerator(name = "c_generator", sequenceName = "DEPARTMENTS_SEQ", allocationSize=1)
	private int department_id;
	
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
	@Override
	public String toString() {
		return "Departaments [department_id=" + department_id + ", department_name=" + department_name + ", manager_id="
				+ manager_id + ", location_id=" + location_id + ", getDepartment_id()=" + getDepartment_id()
				+ ", getDepartment_name()=" + getDepartment_name() + ", getManager_id()=" + getManager_id()
				+ ", getLocation_id()=" + getLocation_id() + "]";
	}
	
	
	
	

}
