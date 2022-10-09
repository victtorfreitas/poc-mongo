package com.mongo.pocmongodb.service.impl;

import com.mongo.pocmongodb.exceptions.EmployeeNotFoundException;
import com.mongo.pocmongodb.model.EmployeeModel;
import com.mongo.pocmongodb.repository.EmployeeRepository;
import com.mongo.pocmongodb.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Override
  public List<EmployeeModel> getAll() {
    return employeeRepository.findAll();
  }

  @Override
  public EmployeeModel getByCode(String code) {
    return employeeRepository.findById(code).orElseThrow(EmployeeNotFoundException::new);
  }

  @Override
  public EmployeeModel create(EmployeeModel employeeModel) {
    EmployeeModel boss = getBoss(employeeModel.getBoss()).orElseThrow();
    employeeModel.setBoss(boss);
    return employeeRepository.save(employeeModel);
  }

  private Optional<EmployeeModel> getBoss(EmployeeModel bossModel) {
    return Optional.ofNullable(bossModel)
        .flatMap(boss -> employeeRepository.findById(boss.getCode()));
  }
}
