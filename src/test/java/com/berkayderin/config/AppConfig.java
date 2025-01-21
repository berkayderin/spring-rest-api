package com.berkayderin.config;

import com.berkayderin.model.Employee;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {
    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","Berkay","Derin"));
        employeeList.add(new Employee("2","Ali","Can"));
        employeeList.add(new Employee("3","Talha","Kerim"));
        employeeList.add(new Employee("3","Bilal","Çamur"));

        return employeeList;
    }
}
