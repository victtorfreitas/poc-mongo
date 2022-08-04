package com.mongo.pocmongodb.service;

import com.mongo.pocmongodb.model.EmployeeModel;
import java.util.List;

public interface EmployeeService {

  List<EmployeeModel> getAll();

  EmployeeModel getByCode(String code);

  EmployeeModel create(EmployeeModel employeeModel);

}
