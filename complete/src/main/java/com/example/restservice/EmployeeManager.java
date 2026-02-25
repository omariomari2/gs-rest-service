package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

    private final Employees employees;

    public EmployeeManager() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("E001", "Alice", "Johnson", "alice.johnson@example.com", "Software Engineer"));
        list.add(new Employee("E002", "Brian", "Lee", "brian.lee@example.com", "Product Manager"));
        list.add(new Employee("E003", "Carmen", "Nguyen", "carmen.nguyen@example.com", "QA Analyst"));
        list.add(new Employee("E004", "Diego", "Martinez", "diego.martinez@example.com", "DevOps Engineer"));
        this.employees = new Employees(list);
    }

    public Employees getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.getEmployees().add(employee);
    }
}

