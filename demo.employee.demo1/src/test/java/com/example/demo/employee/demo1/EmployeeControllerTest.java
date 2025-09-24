package com.example.demo.employee.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    // Add test methods here

    @Test
    public void testGetEmployee() throws Exception{
        //fake the response of the service layer
        Employee emp = new Employee(1L,"John");
        when(employeeService.getEmployeeById(1L)).thenReturn(emp);

        mockMvc.perform(get("/employees/{id}",1)
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    void createEmployee_returnsOk() throws Exception{
        Employee createdEmployee = new Employee(2L,"Bob");
        when(employeeService.registerEmployee(createdEmployee)).thenReturn(createdEmployee);

        mockMvc.perform(post("/employees")
                .contentType("application/json")
                .content("{\"id\":2,\"name\":\"Bob\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Bob"));
   }


    @Test
    public void testUpdateEmployee() throws Exception{
        Employee updatedEmployee =new Employee(1L,"John Updated");
        when(employeeService.updateEmployee(1L,updatedEmployee)).thenReturn(updatedEmployee);

        mockMvc.perform(put("/employees/{id}",1L)
        .contentType("application/json")
                .content("{\"id\":1,\"name\":\"John Updated\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Updated"));
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        Employee deletedEmployee = new Employee(1L, "John");
        when(employeeService.deleteEmployee(1L)).thenReturn(deletedEmployee);

        mockMvc.perform(delete("/employees/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    public void testGetAllEmployees() throws Exception{
        List<Employee> employees = List.of(
                new Employee(1L,"John"),
                new Employee(2L,"Jane"),
                new Employee(3L,"David")
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Jane"))
                .andExpect(jsonPath("$[2].name").value("David"));

    }

}
