package com.mongo.pocmongodb.controller;

import com.mongo.pocmongodb.model.EmployeeModel;
import com.mongo.pocmongodb.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping
  public List<EmployeeModel> getAll() {
    return employeeService.getAll();
  }

  @GetMapping("/{code}")
  public EmployeeModel getByCode(@PathVariable String code) {
    return employeeService.getByCode(code);
  }

  @PostMapping
  public EmployeeModel create(@RequestBody EmployeeModel employeeModel){
    return employeeService.create(employeeModel);
  }

}
