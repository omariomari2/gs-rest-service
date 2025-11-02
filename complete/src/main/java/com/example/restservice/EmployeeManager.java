package com.example.restservice;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

    private final Employees employees;

    public EmployeeManager() {
        this.employees = new Employees(List.of(
                new Employee("E001", "Alice", "Johnson", "alice.johnson@example.com", "Software Engineer"),
                new Employee("E002", "Brian", "Lee", "brian.lee@example.com", "Product Manager"),
                new Employee("E003", "Carmen", "Nguyen", "carmen.nguyen@example.com", "QA Analyst"),
                new Employee("E004", "Diego", "Martinez", "diego.martinez@example.com", "DevOps Engineer")));
    }

    public Employees getEmployees() {
        return employees;
    }
}

