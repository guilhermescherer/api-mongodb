package com.personal.mongodata.repository;

import com.personal.mongodata.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    @Query("{ $and: [ { 'age': { $gte: ?0} }, { 'age': { $lte: ?1} } ] }")
    List<Employee> getEmployeeByAgeRange(Integer start, Integer end);
}
