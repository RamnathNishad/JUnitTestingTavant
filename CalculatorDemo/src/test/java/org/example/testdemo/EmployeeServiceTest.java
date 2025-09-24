package org.example.testdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    EmployeeRepository repository;

    EmployeeService service;

    @BeforeEach
    void setup(){
        repository= Mockito.mock(EmployeeRepository.class); //creating mock
        service=new EmployeeService(repository);
    }

    @Test
    void testRegisterEmployee(){
        Employee emp=new Employee(1,"John");
        service.registerEmployee(emp);
        verify(repository).save(emp); //verifying
    }

    @Test
    void testGetEmployeeById_when_found(){
        //Arrange
        Employee emp=new Employee(1,"John");
        when(repository.findById(1)).thenReturn(emp); //stubbing

        //Act & Assert
        Employee result=service.getEmployeeById(1);
        assertEquals("John",result.getName());

        verify(repository).findById(1); //verifying
    }

    @Test
    void testGetEmployeeById_when_not_found(){
        //Act & Assert
        when(repository.findById(999)).thenReturn(null); //stubbing

        Exception exception= assertThrows(RuntimeException.class, ()->service.getEmployeeById(999));

        assertEquals("Employee not found", exception.getMessage());
    }
}
