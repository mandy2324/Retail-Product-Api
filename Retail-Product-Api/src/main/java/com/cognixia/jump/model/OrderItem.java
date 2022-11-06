package com.cognixia.jump.model;

import javax.validation.constraints.NotBlank;

public class OrderItem {

	
	
	
	
	
	@NotBlank(message = "The product name must not be blank")
	private String name;

	
	
	
	
	
	
	public OrderItem() {

	}

	public OrderItem(@NotBlank(message = "The product name must not be blank") String name) {
		super();
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OrderItem [name=" + name + "]";
	}

}
