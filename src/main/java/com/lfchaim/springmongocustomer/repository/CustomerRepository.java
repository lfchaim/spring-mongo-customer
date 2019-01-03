package com.lfchaim.springmongocustomer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lfchaim.springmongocustomer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	List<Customer> findByNameLikeIgnoreCase(String name);
}
