package com.cognixia.jump.model;

import javax.validation.constraints.NotBlank;

public class OrderItem {

	
	
	
	
	
	@NotBlank(message = "The product name must not be blank")
	private String name;

	private double price;
	
	
	
	
	
	
	public OrderItem() {

	}

	

	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public OrderItem(@NotBlank(message = "The product name must not be blank") String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OrderItem [name=" + name + ", price=" + price + "]";
	}

}
