package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PHONE")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
	@SequenceGenerator(name = "c_generator", sequenceName = "PHONE_SEQ", allocationSize=1)
	private int id;
	private String extension;
	private String isd_code;
	private String phone_number;
	private String type;
	private Integer employee_id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getIsd_code() {
		return isd_code;
	}
	public void setIsd_code(String isd_code) {
		this.isd_code = isd_code;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	
	@Override
	public String toString() {
		return "Phone [id=" + id + ", extension=" + extension + ", isd_code=" + isd_code + ", phone_number="
				+ phone_number + ", type=" + type + ", employee_id=" + employee_id + ", getId()=" + getId()
				+ ", getExtension()=" + getExtension() + ", getIsd_code()=" + getIsd_code() + ", getPhone_number()="
				+ getPhone_number() + ", getType()=" + getType() + ", getEmployee_id()=" + getEmployee_id() + "]";
	}
	
	

}
