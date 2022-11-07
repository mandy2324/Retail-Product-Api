package com.cognixia.jump.model;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	
//	 {
//	        "id": "1",
//	        "name": "FrenchBread",
//	        "price": 2.99,
//	        "expriation": "11-3-2022",
//	        "organic": "true",
//	        "gluten-free": "true",
//	        "in-stock": 1
//	    }
	@Id
	private String prodId;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private double price;
	
	private LocalDate expiration;
	
	@NotBlank
	private boolean organic ;
	
	@NotBlank
	private boolean glutenFree;
	
	@NotBlank
	private int inStock;

	
	public Product() {
		
	}


	public Product(String prodId, @NotBlank String name, @NotBlank double price, LocalDate expiration,
			@NotBlank boolean organic, @NotBlank boolean glutenFree, @NotBlank int inStock) {
		super();
		this.prodId = prodId;
		this.name = name;
		this.price = price;
		this.expiration = expiration;
		this.organic = organic;
		this.glutenFree = glutenFree;
		this.inStock = inStock;
	}


	

	public String getProdId() {
		return prodId;
	}


	public void setProdId(String prodId) {
		this.prodId = prodId;
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


	

	public LocalDate getExpiration() {
		return expiration;
	}


	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}


	public boolean isOrganic() {
		return organic;
	}


	public void setOrganic(boolean organic) {
		this.organic = organic;
	}


	public boolean isGlutenFree() {
		return glutenFree;
	}


	public void setGlutenFree(boolean glutenFree) {
		
		this.glutenFree = glutenFree;
	}


	public int getInStock() {
		return inStock;
	}


	public void setInStock(int inStock) {
		this.inStock = inStock;
	}


	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", name=" + name + ", price=" + price + ", expiration=" + expiration
				+ ", organic=" + organic + ", glutenFree=" + glutenFree + ", inStock=" + inStock + "]";
	}
	
	
	
	
	
	
}
