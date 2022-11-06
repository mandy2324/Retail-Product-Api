package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.CheckOut;
import com.cognixia.jump.model.Product;
import com.cognixia.jump.repository.CheckoutRepository;

@RequestMapping("/api")
@RestController
public class CheckoutController {

	@Autowired
	CheckoutRepository repo;

	// Get request to get All items in cart

	@GetMapping("/checkout")
	public List<CheckOut> getCheckout() {
		return repo.findAll();

	}
 
	
	
	// post request
	
	
	
	
	
	//delete item fom cart 
	
	
	
	
	
	
	
	
	
	
	
}
