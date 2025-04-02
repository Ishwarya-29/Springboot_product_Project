package com.day2.demo_day2.mongodb.repository;

import com.day2.demo_day2.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<Product,String> {
}
