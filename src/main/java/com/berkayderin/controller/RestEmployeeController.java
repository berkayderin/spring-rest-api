package com.berkayderin.controller;

import com.berkayderin.model.Employee;
import com.berkayderin.model.UpdateEmployeeRequest;
import com.berkayderin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList() {
        return employeeService.getAllEmployeeList();
    }

    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(
            @RequestParam(name = "firstName", required = false) String firstName, // required = false ise parametre
                                                                                  // gönderilmeyebilir.
            @RequestParam(name = "lastName", required = false) String lastName) {

        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping(path = "/add")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeeService.addEmployee(newEmployee);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id", required = true) String id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/update/{id}")
    public Employee updateEmployee(@PathVariable(name = "id", required = true) String id,
            @RequestBody UpdateEmployeeRequest req) {
        return null;
    }
}
