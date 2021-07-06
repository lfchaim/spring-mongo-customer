package com.lfchaim.springmongocustomer.repository;

import com.lfchaim.springmongocustomer.model.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

	Flux<Customer> findByNameLikeIgnoreCase(String name);

	@Query("{ id: { $exists: true }}")
	Flux<Customer> findAll(final Pageable page);
}
