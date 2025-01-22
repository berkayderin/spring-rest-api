package com.berkayderin.service;

import com.berkayderin.model.Employee;
import com.berkayderin.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;  // @Autowired ile entejte edilmezse employeeRepository null olur.

    public List<Employee> getAllEmployeeList(){
        return employeeRepository.getAllEmployeeList();
    }
}
