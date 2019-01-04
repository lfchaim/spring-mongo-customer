package com.lfchaim.springmongocustomer.controller;

import com.lfchaim.springmongocustomer.model.Customer;
import com.lfchaim.springmongocustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

  private CustomerService customerService;

  @Autowired
  public CustomerController(final CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping(path = "/customer")
  public Flux<Customer> listr() {
    return this.customerService.listCustomer();
  }

  @GetMapping(path = "/customer/{id}")
  public Mono<Customer> getById(@PathVariable String id) {
    return this.customerService.getById(id);
  }

  @GetMapping(path = "/customer/{page}/{count}")
  public Flux<Customer> listPaging(@PathVariable int page, @PathVariable int count) {
    return this.customerService.listPaging(count, page);
  }

  @GetMapping(path = "/customer/{name}/name")
  public Flux<Customer> listPaging(@PathVariable String name) {
    return this.customerService.findByName(name);
  }

  @PostMapping(path = "/customer")
  public Mono<Customer> save(@RequestBody Customer customer) {
    return this.customerService.saveCustomer(customer);
  }

  @PutMapping(path = "/customer")
  public Mono<Customer> editar(@RequestBody Customer customer) {
    return this.customerService.saveCustomer(customer);
  }

  @DeleteMapping(path = "/customer/{id}")
  public Mono<Void> deletar(@PathVariable String id) {
    return this.customerService.deleteCustomer(id);
  }

}
