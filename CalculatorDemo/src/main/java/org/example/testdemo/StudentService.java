package org.example.testdemo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    List<Student> students=new ArrayList<>();

    public List<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
       Student student= students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

       //if the student is not found, throw custom exception
       if(student==null){
           throw new StudentNotFoundException("Student with id "+id+" not found");
       }

       return student;
    }

    public boolean login(String username, String password) {
        //dummy implementation
        return "admin".equals(username) && "password".equals(password);
    }

    public boolean isValidAge(int age) {
        return age >= 18 && age <= 30;
    }
}
