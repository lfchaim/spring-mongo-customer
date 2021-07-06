package com.lfchaim.springmongocustomer.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.lfchaim.springmongocustomer.model.Customer;
import com.lfchaim.springmongocustomer.model.CustomerByName;
import com.lfchaim.springmongocustomer.repository.CustomerByNameRepository;
import com.lfchaim.springmongocustomer.repository.CustomerRepository;
import com.lfchaim.springmongocustomer.util.LogUtil;

import reactor.core.publisher.Flux;

@Service
public class CustomerQueryService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerByNameRepository customerByNameRepository;


	public Flux<Customer> listCustomerById( Collection<String> listId ){
		final Criteria criteria = Criteria.where("id").in(listId);
		final Query query = new Query(criteria);
		return Flux.just(mongoTemplate.find(query, Customer.class)).flatMap(Flux::fromIterable);
	}
	
	public Flux<CustomerByName> listCustomerByNameByName( String name ){
		//final Criteria criteria = Criteria.where("name").regex(name);
		Criteria criteria = Criteria.where("name").regex(name, "i");
		final Query query = new Query(criteria);
		return Flux.just(mongoTemplate.find(query, CustomerByName.class)).flatMap(Flux::fromIterable);
	}
	
	public Flux<Customer> listCustomerByName( String name ){
		List<Calendar> listTime = new ArrayList<>();
		listTime.add(Calendar.getInstance());
		//Flux<CustomerByName> custByName = listCustomerByNameByName(name);
		Flux<CustomerByName> custByName = customerByNameRepository.findLikeName(name);
		listTime.add(Calendar.getInstance());
		List<CustomerByName> listCust = custByName.collectList().block();
		listTime.add(Calendar.getInstance());
		List<String> listKey = (listCust.stream().map(CustomerByName::getIdCustomer)).collect(Collectors.toList());
		listTime.add(Calendar.getInstance());
		System.out.println(LogUtil.printTime(listTime));
		return listCustomerById(listKey);
	}
}
