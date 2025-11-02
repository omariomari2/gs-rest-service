package com.example.restservice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employees {

    private List<Employee> employees;

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employees() {
    }

    @JsonProperty("Employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

