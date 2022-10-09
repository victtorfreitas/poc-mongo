package com.mongo.pocmongodb.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("employee")
public class EmployeeModel {

  @Id
  private String code;

  private String name;
  private Integer age;
  private BigDecimal salary;

  @DBRef
  private EmployeeModel boss;
}
