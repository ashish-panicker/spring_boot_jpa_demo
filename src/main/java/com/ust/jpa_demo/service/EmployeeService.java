package com.ust.jpa_demo.service;

import com.ust.jpa_demo.domain.Employee;

import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Optional<Employee> getEmployee(int empId);

    Employee updateEmployee(Employee employee);
}
