package com.lfchaim.springmongocustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lfchaim.springmongocustomer.model.Customer;
import com.lfchaim.springmongocustomer.model.CustomerByName;
import com.lfchaim.springmongocustomer.service.CustomerByNameService;
import com.lfchaim.springmongocustomer.service.CustomerQueryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerByNameController {

	@Autowired
	private CustomerByNameService customerService;
	
	@Autowired
	private CustomerQueryService custQueryService;

	@GetMapping(path = "/customerbyname")
	public Flux<CustomerByName> getByName() {
		return this.customerService.listCustomerByName();
	}

	@GetMapping(path = "/customerbyname/{name}/name")
	public Flux<Customer> listByName(@PathVariable String name) {
		return this.custQueryService.listCustomerByName(name);
	}
	
	@GetMapping(path = "/customerbyname/{id}")
	public Mono<CustomerByName> getByNameId(@PathVariable String id) {
		return this.customerService.getByNameId(id);
	}

	@PostMapping(path = "/customerbyname")
	public Mono<CustomerByName> save(@RequestBody CustomerByName customer) {
		return this.customerService.saveCustomerByName(customer);
	}

}
