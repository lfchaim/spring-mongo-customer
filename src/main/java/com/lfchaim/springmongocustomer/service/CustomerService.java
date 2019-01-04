package com.lfchaim.springmongocustomer.service;

import com.lfchaim.springmongocustomer.model.Customer;
import com.lfchaim.springmongocustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

  private CustomerRepository customerRepository;

  @Autowired
  public CustomerService(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

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
    return customerRepository.save(customerAdd);
  }

  public Mono<Void> deleteCustomer(String id) {
    Customer customer = new Customer();
    customer.setId(id);
    return customerRepository.delete(customer);
  }

  public Mono<Customer> getById(String id) {
    return customerRepository.findById(id);
  }

}
