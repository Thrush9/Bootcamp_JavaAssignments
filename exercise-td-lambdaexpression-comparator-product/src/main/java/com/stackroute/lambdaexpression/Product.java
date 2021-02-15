package com.stackroute.lambdaexpression;

public class Product {

	private int id;
	private String category;
	private String name;
	private double price;
	
	public Product(int id, String type, String name, double cost) {
		this.id = id;
		this.category = type;
		this.name = name;
		this.price = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "id=" + id + ", category='" + category + "', name='" + name + "', price=" + price;
	}

	

}
