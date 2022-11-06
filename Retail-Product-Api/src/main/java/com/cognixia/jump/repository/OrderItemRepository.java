package com.cognixia.jump.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.OrderItem;

@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, String>{

}
