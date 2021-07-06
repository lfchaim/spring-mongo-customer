package com.lfchaim.springmongocustomer.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
