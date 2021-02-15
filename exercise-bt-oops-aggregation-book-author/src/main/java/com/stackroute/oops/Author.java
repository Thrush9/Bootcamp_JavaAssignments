package com.stackroute.oops;

public class Author {
	/* Define the properties as given in problem.md */
	private String name;
	private String country;

	/*
	 * Complete the Parameterized constructor to initialize all properties of Author
	 */
	public Author(String name, String country) {
		this.name = name;
		this.country = country;
	}

	/*
	 * Complete the Getters and Setters
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/*
	 * This method should return a string containing the author details in below
	 * format Author{name='xxxxx', country='xxxx'}
	 */
	public String getAuthorDetails() {
		return "Author{name=" + "'" + getName() + "'," + " country=" + "'" + getCountry() + "'}";
	}

}