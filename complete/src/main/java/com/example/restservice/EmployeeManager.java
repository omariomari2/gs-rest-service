package com.example.restservice;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

    private final EmployeeRepository employeeRepository;

    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void seedData() {
        if (employeeRepository.count() == 0) {
            employeeRepository.save(new Employee("E001", "Alice", "Johnson", "alice.johnson@example.com", "Software Engineer"));
            employeeRepository.save(new Employee("E002", "Brian", "Lee", "brian.lee@example.com", "Product Manager"));
            employeeRepository.save(new Employee("E003", "Carmen", "Nguyen", "carmen.nguyen@example.com", "QA Analyst"));
            employeeRepository.save(new Employee("E004", "Diego", "Martinez", "diego.martinez@example.com", "DevOps Engineer"));
        }
    }

    public Employees getEmployees() {
        return new Employees(employeeRepository.findAll());
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}

