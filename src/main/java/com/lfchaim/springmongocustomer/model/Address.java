package com.lfchaim.springmongocustomer.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Address {

  @Field("address")
  private String address;

  @Field("number")
  private String number;

  @Field("complement")
  private String complement;

  @Field("zipcode")
  private String zipCode;

}
