package com.lfchaim.springmongocustomer.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.lfchaim.springmongocustomer.model.CustomerByName;

import reactor.core.publisher.Flux;

public interface CustomerByNameRepository extends ReactiveMongoRepository<CustomerByName, String> {

	@Query("{'name': {$regex: ?0 }})")
	Flux<CustomerByName> findLikeName(String name);
	
}
