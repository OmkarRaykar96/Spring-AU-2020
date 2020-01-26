package com.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private int pincode;
	private String Street;

	// Default Constructor
	public Address() {

	}

	// Parameterized Constructor
	public Address(int pincode, String street) {
		super();
		this.pincode = pincode;
		Street = street;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

}