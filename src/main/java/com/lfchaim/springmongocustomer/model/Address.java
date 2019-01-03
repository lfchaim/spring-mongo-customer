package com.lfchaim.springmongocustomer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Address {

	@Id
    private String id;

    private String address;
    
    private String number;
    
    private String complement;
    
    private String zipCode;
    
}
