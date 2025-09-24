package org.example.testdemo;


public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository=repository;
    }

    public Employee getEmployeeById(int id){
        Employee emp = repository.findById(id);

        if(emp==null) throw new RuntimeException(("Employee not found"));

        return emp;
    }

    public void registerEmployee(Employee emp){
        repository.save(emp);
    }
}
