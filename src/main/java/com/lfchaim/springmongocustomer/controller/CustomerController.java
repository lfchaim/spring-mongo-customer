package com.lfchaim.springmongocustomer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lfchaim.springmongocustomer.model.Customer;
import com.lfchaim.springmongocustomer.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> listr() {
        return this.customerService.listCustomer();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Optional<Customer> getById(@PathVariable String id) {
        return this.customerService.getById(id);
    }

    @RequestMapping(value = "/customer/{page}/{count}", method = RequestMethod.GET)
    public Page<Customer> listPaging(@PathVariable int page, @PathVariable int count) {
        return this.customerService.listPaging(count, page);
    }

    @RequestMapping(value = "/customer/{name}/name", method = RequestMethod.GET)
    public List<Customer> listPaging(@PathVariable String name) {
        return this.customerService.findByName(name);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.saveCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Customer editar(@RequestBody Customer customer) {
        return this.customerService.saveCustomer(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
        this.customerService.deleteCustomer(id);
    }

}
