//package com.cognixia.jump.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.cognixia.jump.exception.ResourceNotFoundException;
//import com.cognixia.jump.model.CheckOut;
//import com.cognixia.jump.model.OrderItem;
//import com.cognixia.jump.model.Product;
//import com.cognixia.jump.repository.CheckoutRepository;
//import com.cognixia.jump.repository.OrderItemRepository;
//import com.cognixia.jump.repository.ProductRepository;
//
//@Service
//public class CheckoutService {
//
//	@Autowired
//	CheckoutRepository Checkoutrepo;
//	
//	@Autowired
//	ProductRepository prodRepo;
//	
//	@Autowired
//	OrderItemRepository oIRepo;
//	
//	// if i wrap all mymethods in this 
////	public somethig(){
//	
//	
//	// getting prod name
//	public Product getProductNamefromP( String name) throws ResourceNotFoundException {
//		Optional<Product> found = prodRepo.findById(name);
//		if( found.isPresent() ) {
//			return found.get();		
//			}
//	throw new ResourceNotFoundException("Product name not found");
//}
//	
////	 getting order item name
//	public OrderItem getOrderItemName (String name) throws ResourceNotFoundException{
//		Optional<OrderItem> found = oIRepo.findById(name);
//		if( found.isPresent() ) {
//			return found.get();		
//			}
//	throw new ResourceNotFoundException("name you entered not found");
//	
//	}
//
////	public Product getPriceFromP(double price ) {
////		Optional<Product> found = prodRepo.findAll();
//	}
//	
//	
//	
////	comparing() {}
//	
////	"A" .equal "A" --> 
////	MyA . equal yourA
////	if this is true than  return yourA 
//	
////	yourPrice
//	
//	
//	
////	{prod  name => extract price }
////	 display name and price 
//	//or throw error if anything doesnt work out 
//	
////	yourA and price this is coming from same place 
//	
//
//	
//	
//	
//	
//	
//	
//	//  }
//	
//	
//}
