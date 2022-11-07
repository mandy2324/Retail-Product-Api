package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.CheckOut;
import com.cognixia.jump.model.OrderItem;
import com.cognixia.jump.model.Product;

@Repository
public interface CheckoutRepository extends MongoRepository<CheckOut, String> {

}
