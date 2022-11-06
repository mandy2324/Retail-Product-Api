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
import com.cognixia.jump.model.Product;
import com.cognixia.jump.repository.ProductRepository;

@RequestMapping("/api")
@RestController
public class ProductController {
	@Autowired
	ProductRepository repo;
	
	
	// Get request to get All products
	@GetMapping("/product")
	public List<Product> getProducts() {
		return repo.findAll();
	}
	
	
	
	// Get request to get product by id
	
	
	@GetMapping("/product/{ProdId}")
	public ResponseEntity<?> getProduct(@PathVariable String ProdId) throws ResourceNotFoundException {
		
		Optional<Product> found = repo.findById(ProdId);
		
		if(found.isEmpty()) {
			throw new ResourceNotFoundException("Product with id = " + ProdId + " was not found");
		}
		
		return ResponseEntity.status(200).body(found.get());
	}
	
	
	// adding a product to collection 
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		product.setProdId(null);
		
		
		Product created = repo.save(product);
		
		return ResponseEntity.status(201).body(created);
	}
	
	
	// deletig a product from collection 
	
	@DeleteMapping("/product/{prodId}")
	public ResponseEntity<?> deleteProduct(@PathVariable String prodId) throws ResourceNotFoundException {
		
		Optional<Product> found = repo.findById(prodId);
		
		if( found.isEmpty() ) {
			
			throw new ResourceNotFoundException("Product with id = " + prodId + " was not found");
		}
		
		repo.deleteById(prodId);
		return ResponseEntity.status(200).body(found.get());
	}
	
	
	
}
