package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Countries {
	
	@Id
	private String country_id;
	private String country_name;
	private Integer region_id;
	
	
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	
	@Override
	public String toString() {
		return "Countries [country_id=" + country_id + ", country_name=" + country_name + ", region_id=" + region_id
				+ ", getCountry_id()=" + getCountry_id() + ", getCountry_name()=" + getCountry_name()
				+ ", getRegion_id()=" + getRegion_id() + "]";
	}
	
	
	
	
	
}
