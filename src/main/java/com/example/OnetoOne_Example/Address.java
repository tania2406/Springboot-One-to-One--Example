package com.example.OnetoOne_Example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int aid;	
	String acity;
	String astreet;
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnoreProperties("address")
	Employee employee;

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAcity() {
		return acity;
	}
	public void setAcity(String acity) {
		this.acity = acity;
	}
	public String getAstreet() {
		return astreet;
	}
	public void setAstreet(String astreet) {
		this.astreet = astreet;
	}
}