package com.berkayderin.service;

import com.berkayderin.model.Employee;
import com.berkayderin.model.UpdateEmployeeRequest;
import com.berkayderin.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository; // @Autowired ile enjekte edilmezse employeeRepository null olur.

    public List<Employee> getAllEmployeeList() {
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee addEmployee(Employee newEmployee) {
        return employeeRepository.addEmployee(newEmployee);
    }

    public boolean deleteEmployee(String id) {
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest req) {
        return employeeRepository.updateEmployee(id, req);
    }
}
