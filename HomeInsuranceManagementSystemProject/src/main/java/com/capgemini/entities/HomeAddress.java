package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity
public class HomeAddress {
	
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zip;
	@Column(name="residence_Use")
	private String residenceUse;
	
	@Column(name="residence_Type")
	private String residenceType;
	
	public String getResidenceType() {
		return residenceType;
	}
	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getResidenceUse() {
		return residenceUse;
	}
	public void setResidenceUse(String residenceUse) {
		this.residenceUse = residenceUse;
	}
	
	
}
