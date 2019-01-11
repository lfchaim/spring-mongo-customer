package com.lfchaim.springmongocustomer.service;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lfchaim.springmongocustomer.model.Customer;
import com.lfchaim.springmongocustomer.model.CustomerByName;
import com.lfchaim.springmongocustomer.model.CustomerEvents;
import com.lfchaim.springmongocustomer.repository.CustomerByNameRepository;
import com.lfchaim.springmongocustomer.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerByNameRepository customerByNameRepository;

	public Flux<Customer> listCustomer() {
		return customerRepository.findAll();
	}

	public Flux<Customer> listPaging(int count, int page) {
		final Pageable pages = PageRequest.of(page, count);
		return customerRepository.findAll(pages);
	}

	public Flux<Customer> findByName(String name) {
		return customerRepository.findByNameLikeIgnoreCase(name);
	}

	public Mono<Customer> saveCustomer(Customer customerAdd) {
		Mono<Customer> retVal = customerRepository.save(customerAdd);
		String id = customerAdd.getId();
		CustomerByName pojo = new CustomerByName(customerAdd.getName()+"_"+id,id);
		Mono<CustomerByName> saved = customerByNameRepository.save(pojo);
		System.out.println(saved.block().getName());
		return retVal;
	}

	public Mono<Void> deleteCustomer(String id) {
		Customer customer = new Customer();
		customer.setId(id);
		return customerRepository.delete(customer);
	}

	public Mono<Customer> getById(String id) {
		return customerRepository.findById(id);
	}

	public Flux<CustomerEvents> streams(String carId) {
		return getById(carId).flatMapMany(car -> {
			Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
			Flux<CustomerEvents> events = Flux.fromStream(Stream.generate(() -> new CustomerEvents(car, new Date())));
			return Flux.zip(interval, events).map(Tuple2::getT2);
		});
	}

}
