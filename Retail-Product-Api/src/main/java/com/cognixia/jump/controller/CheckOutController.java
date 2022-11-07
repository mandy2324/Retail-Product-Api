package com.cognixia.jump.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.CheckOut;
import com.cognixia.jump.model.OrderItem;
import com.cognixia.jump.model.Product;
import com.cognixia.jump.repository.CheckoutRepository;
import com.cognixia.jump.repository.OrderItemRepository;
import com.cognixia.jump.repository.ProductRepository;
@RestController
@RequestMapping("/api")
public class CheckOutController {
	
	@Autowired
	CheckoutRepository repo;
	
	
	@Autowired
	ProductRepository prodrepo;
	
	
	@Autowired
	OrderItemRepository orderRepo;
	
	// Get all items in cart
	
	@GetMapping("/checkout")
	public List<OrderItem>getCheckOut() {
		return orderRepo.findAll();
	}
	
	// add an item to cart
	
	@PostMapping("/checkout/add")
	public ResponseEntity<?> addItemToCart (@RequestBody OrderItem orderItem) {
		
		if(prodrepo.findProductByname(orderItem.getName()).size() == 0
				&& prodrepo.findProductByPrice(orderItem.getPrice()).size() == 0) {
			
			return ResponseEntity.status(400).body("Product does not exist");
			
		}
		
		if(prodrepo.existsById(prodrepo.findProductByname(orderItem.getName()).get(0).getProdId())) {
			
			
//			&& prodrepo.findProductByPrice(orderItem.getPrice()).get(0).getPrice()) {

			//double price = prodrepo.findProductByProductname(customerOrder.getName()).get(0).getPrice();
			
			OrderItem created = orderRepo.save(orderItem);
			
			return ResponseEntity.status(201).body(created);
		
		}
		return ResponseEntity.status(400).body("Product does not exist");
	
	}
	
		@DeleteMapping("/checkout/{name}")
		public ResponseEntity<?> deleteName(@PathVariable String name) throws ResourceNotFoundException {
			
			Optional<OrderItem> found = orderRepo.findById(name);
			
			if( found.isEmpty() ) {
				
				throw new ResourceNotFoundException("Product with id = " + name + " was not found");
			}
			
			repo.deleteById(name);
			return ResponseEntity.status(200).body(found.get());
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}