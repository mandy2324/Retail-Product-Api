package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	public List<Product> getPriceFromP(double price);

	
}

