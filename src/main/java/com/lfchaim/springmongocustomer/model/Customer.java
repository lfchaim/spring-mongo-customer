package com.lfchaim.springmongocustomer.model;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
public class Customer {

  @Id
  @Indexed
  private String id;

  @Field("name")
  private String name;

  @Field("email")
  private String email;

  @Field("address")
  private List<Address> address;

}
