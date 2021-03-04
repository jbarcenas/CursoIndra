package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;





@Entity
@Table(name="REGIONS")
public class Regions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
	@SequenceGenerator(name = "c_generator", sequenceName = "REGION_SEQ", allocationSize=1)
	private int region_id;
	private String region_name;
	
	
	
	public int getRegion_id() {
		return region_id;
	}
	
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	
	public String getRegion_name() {
		return region_name;
	}
	
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	@Override
	public String toString() {
		return "Regions [region_id=" + region_id + ", region_name=" + region_name + ", getRegion_id()=" + getRegion_id()
				+ ", getRegion_name()=" + getRegion_name() + "]";
	}
	
	
	
	
	
}
