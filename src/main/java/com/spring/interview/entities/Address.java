package com.spring.interview.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address {
	
	private String street;
	private String city;
	private String province;
	private String country;
	public Address() {
		
	}
	public Address(String street, String city, String province, String country) {
		
		this.street = street;
		this.city = city;
		this.province = province;
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
