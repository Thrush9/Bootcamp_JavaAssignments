package com.stackroute.streams;

public class Country {
	
	
	private String name;
	private String countryCode;
	
	public Country(String code,String name) {
		this.name = name;
		this.countryCode = code;
	}

	public Country() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
}
