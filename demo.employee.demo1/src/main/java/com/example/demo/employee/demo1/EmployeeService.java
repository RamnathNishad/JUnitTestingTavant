package com.example.demo.employee.demo1;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee registerEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    Employee deleteEmployee(Long id);
}
