package com.lfchaim.springmongocustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfchaim.springmongocustomer.model.CustomerByName;
import com.lfchaim.springmongocustomer.repository.CustomerByNameRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerByNameService {

	@Autowired
	private CustomerByNameRepository customerByNameRepository;

	public Mono<CustomerByName> saveCustomerByName(CustomerByName customerAdd) {
		Mono<CustomerByName> retVal = customerByNameRepository.save(customerAdd);
		return retVal;
	}

	public Flux<CustomerByName> listCustomerByName() {
		return customerByNameRepository.findAll();
	}
	
	public Mono<CustomerByName> getByNameId(String id) {
		return customerByNameRepository.findById(id);
	}

}
