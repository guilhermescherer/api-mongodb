package com.personal.mongodata.service.impl;

import com.personal.mongodata.model.Employee;
import com.personal.mongodata.repository.EmployeeRepository;
import com.personal.mongodata.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getById(String id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found employee."));
    }

    @Override
    public Employee save(Employee employee) {

        Employee boss = this.employeeRepository.findById(employee.getBoss().getId())
                .orElseThrow(() -> new RuntimeException("Not found boss."));

        employee.setBoss(boss);

        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeByAgeRange(Integer start, Integer end) {
        return this.employeeRepository.getEmployeeByAgeRange(start, end);
    }
}
