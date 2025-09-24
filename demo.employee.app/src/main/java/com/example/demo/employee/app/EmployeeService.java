package com.example.demo.employee.app;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

     Optional<Employee> getEmployeeById(Long id);
     List<Employee> getEmployees();
     Employee registerEmployee(Employee emp);
     Employee updateEmployee(Long id, Employee emp);
     Employee deleteEmployee(Long id);

}

//public class EmployeeService {
//
//    private final EmployeeRepository repository;
//
//    public EmployeeService(EmployeeRepository repository){
//        this.repository=repository;
//    }
//
//    public Optional<Employee> getEmployeeById(Long id){
//        return repository.findById(id);
//    }
//
//    public Employee registerEmployee(Employee emp){
//        return repository.save(emp);
//    }
//}

