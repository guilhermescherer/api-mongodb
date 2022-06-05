package com.personal.mongodata.controller;

import com.personal.mongodata.model.Employee;
import com.personal.mongodata.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/range")
    public List<Employee> getByAgeRange(
            @RequestParam("start") Integer start,
            @RequestParam("end") Integer end) {
        return employeeService.getEmployeeByAgeRange(start, end);
    }
}
