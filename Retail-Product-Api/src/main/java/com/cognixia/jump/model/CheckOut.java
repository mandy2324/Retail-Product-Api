package com.cognixia.jump.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CheckOut {
 
	// res
	private String userId;
	// user id ;
	private List <OrderItem> orderItems;
	
	private double total;
	
	
	public CheckOut() {
		
	}


	public CheckOut(String userId, List<OrderItem> orderItems, double total) {
		super();
		this.userId = userId;
		this.orderItems = orderItems;
		this.total = total;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> ordeItems) {
		this.orderItems = ordeItems;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "CheckOut [userId=" + userId + ", ordeItems=" + orderItems + ", total=" + total + "]";
	}
	
	
	
	
	
	
	
	
	//name
	// if name != name in collection than
	// throw error msg or try catch block 
	// \else if name = name in collection 
//		get item name,price
//		insert it in list of checkout item 
	
	
	
	// get req to get all items in cart ==== simple
	
	// post req to add itms to cart======  req- send ["spinach,lemon,kale ,grapes, lemon,lemon,spinch] && res  [name, price  
	//  req -> name<list>

	
	//	res => user id, 
//				<List> names === names in our product list {
//							print name and get price }
//		 &&   }, add prices of list and display to a total var   
	//
	
	// delete to remove item frrom card by id / name
	
	//post to find total 
	
	
	
	
	
	
}
