package com.personal.mongodata.service;

import com.personal.mongodata.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(String id);

    Employee save(Employee employee);

    List<Employee> getEmployeeByAgeRange(Integer start, Integer end);
}
