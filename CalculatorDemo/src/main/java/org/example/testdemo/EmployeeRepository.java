package org.example.testdemo;

public interface EmployeeRepository {
    void save(Employee employee);
    Employee findById(int id);
}

