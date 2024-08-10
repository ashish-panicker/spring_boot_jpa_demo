package com.ust.jpa_demo.service;

import com.ust.jpa_demo.domain.Employee;
import com.ust.jpa_demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(int empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
