package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Locations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
	@SequenceGenerator(name = "c_generator", sequenceName = "LOCATIONS_SEQ", allocationSize=1)
	private int location_id;
	private String street_address;
	private String postal_code;
	private String city;
	private String state_province;
	private String country_id;
	
	
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	
	@Override
	public String toString() {
		return "Locations [location_id=" + location_id + ", street_address=" + street_address + ", postal_code="
				+ postal_code + ", city=" + city + ", state_province=" + state_province + ", country_id=" + country_id
				+ ", getLocation_id()=" + getLocation_id() + ", getStreet_address()=" + getStreet_address()
				+ ", getPostal_code()=" + getPostal_code() + ", getCity()=" + getCity() + ", getState_province()="
				+ getState_province() + ", getCountry_id()=" + getCountry_id() + "]";
	}
	
	
}
