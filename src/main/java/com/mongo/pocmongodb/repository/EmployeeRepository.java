package com.mongo.pocmongodb.repository;

import com.mongo.pocmongodb.model.EmployeeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeModel, String> {

}
