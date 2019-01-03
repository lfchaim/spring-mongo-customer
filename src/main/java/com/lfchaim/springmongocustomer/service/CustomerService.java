package com.lfchaim.springmongocustomer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lfchaim.springmongocustomer.model.Customer;
import com.lfchaim.springmongocustomer.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> listCustomer() {
        return customerRepository.findAll();
    }

    public Page<Customer> listPaging(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return customerRepository.findAll(pages);
    }

    public List<Customer> findByName(String name) {
        return customerRepository.findByNameLikeIgnoreCase(name);
    }

    public Customer saveCustomer(Customer customerAdd) {
        return customerRepository.save(customerAdd);
    }

    public void deleteCustomer(String id) {
    	Customer customer = new Customer();
    	customer.setId(id);
        customerRepository.delete(customer);
    }

    public Optional<Customer> getById(String id) {
        return customerRepository.findById(id);
    }

}
