package com.example.demo.employee.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployee_Found() throws Exception {

        Employee e = new Employee(1L, "John");
        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.of(e));

        mockMvc.perform(get("/employees/{id}", 1)
                        .accept("application/json"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    void testGetEmployee_notFound_returns404() throws Exception {
        when(employeeService.getEmployeeById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/employees/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createEmployee_returns201() throws Exception {
        //Employee in = new Employee(null, "Bob");
        Employee saved = new Employee(5L, "Bob");
        when(employeeService.registerEmployee(any(Employee.class))).thenReturn(saved);

        String json = "{\"name\":\"Bob\"}";

        mockMvc.perform(post("/employees")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.name").value("Bob"));
    }

    @Test
    public void testUpdateEmployee() throws Exception {

        Employee updated = new Employee(1L, "John Doe");
        when(employeeService.updateEmployee(eq(1L),any(Employee.class))).thenReturn(updated);


        mockMvc.perform(put("/employees/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1,\"name\": \"John Doe\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
               }
    @Test
    public void testDeleteEmployee() throws Exception {
        Employee deleted = new Employee(1L, "John Doe");
        when(employeeService.deleteEmployee(eq(1L))).thenReturn(deleted);

        mockMvc.perform(delete("/employees/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEmployees() throws Exception {
        List<Employee> emps = new ArrayList<Employee>();
        emps.add(new Employee(1L, "John"));
        emps.add(new Employee(2L, "Jane"));
        emps.add(new Employee(3L, "David"));

        when(employeeService.getEmployees()).thenReturn(emps);

        mockMvc.perform(get("/employees")
                        .accept("application/json"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.length()").value(3))
                        .andExpect(jsonPath("$[0].name").value("John"))
                        .andExpect(jsonPath("$[1].name").value("Jane"))
                        .andExpect(jsonPath("$[2].name").value("David"));

    }
}


