package com.berkayderin.repository;

import com.berkayderin.model.Employee;
import com.berkayderin.model.UpdateEmployeeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList() {
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        Employee findEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();

        if (firstName == null && lastName == null) {
            return employeeList;
        }

        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)
                        && employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            } else if (firstName != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) { // ignoreCase ile büyük küçük harf farkını
                                                                           // göz ardı eder.
                    employeeWithParams.add(employee);
                }
            } else if (lastName != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }
        }
        return employeeWithParams;
    }

    public Employee addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id) {
        Employee findEmployee = getEmployeeById(id);
        if (findEmployee != null) {
            employeeList.remove(findEmployee);
            return true;
        }
        return false;
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
        Employee employeeToUpdate = getEmployeeById(id);

        if (employeeToUpdate == null) {
            return null;
        }

        employeeToUpdate.setFirstName(request.getFirstName());
        employeeToUpdate.setLastName(request.getLastName());

        int employeeIndex = employeeList.indexOf(employeeToUpdate);
        employeeList.set(employeeIndex, employeeToUpdate);

        return employeeToUpdate;
    }
}
