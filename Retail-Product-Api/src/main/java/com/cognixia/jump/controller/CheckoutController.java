package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.CheckOut;
import com.cognixia.jump.model.OrderItem;
import com.cognixia.jump.repository.CheckoutRepository;
import com.cognixia.jump.repository.ProductRepository;
import com.cognixia.jump.service.CheckoutService;

@RequestMapping("/api")
@RestController
public class CheckoutController {

	@Autowired
	CheckoutRepository Checkoutrepo;
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	CheckoutService cService;
	
	
	
	// Get request to get All items in cart

	@GetMapping("/checkout")
	public List<CheckOut> getCheckout() {
		return Checkoutrepo.findAll();

	}
 
	
	
	// post request
	@PostMapping("/checkout/add")
	public ResponseEntity<?> addItemTocart (@RequestBody OrderItem orderItem ){
		
		if(cService.getOrderItemName(null).equals(cService.getProductNamefromP(null) ) ) {
			return ;
		}
		
//		OrderItem created = service.something();		
//		return ResponseEntity.status(201).body(created);
	}
	
	
	
	
	//delete item fom cart 
	
	
	
	
	
	
	
	
	
	
	
}
