package org.example.testdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTest(){

        StudentService studentService=new StudentService();

        Student student =new Student(1,"John");
        studentService.addStudent(student);

        List<Student> students=studentService.getStudents();


        boolean actualResult=students.isEmpty();

        //assertTrue((actualResult);

        //assertTrue(() -> actualResult);

        //assertTrue(actualResult, "The list is not empty");

        //assertTrue(()->actualResult, "The list is not empty");

        assertTrue(()->actualResult, ()-> "The list is not empty");
    }

    @Test
    public void getStudentsTestUsingAssertFalse(){

        StudentService studentService=new StudentService();

        //Student student =new Student(1,"John");
        //studentService.addStudent(student);

        List<Student> students=studentService.getStudents();

        boolean actualResult=students.isEmpty();

        //assertFalse(actualResult);

        //assertFalse(actualResult, "The list is not empty");

        //assertFalse(()->actualResult);

        //assertFalse(()->actualResult, "The list is not empty");

        assertFalse(()->actualResult, ()-> "The list is not empty");
    }

    @Test
    public void getStudentByIdTestUsingAssertNull(){
        StudentService studentService=new StudentService();

        Student student =new Student(1,"John");
        studentService.addStudent(student);

        Student actualObject=studentService.getStudentById(2);

        //assertNull(actualObject);

        //assertNull(actualObject, "The object is not null");

        assertNull(actualObject, ()-> "The object is not null");

    }

    @Test
    public void getStudentByIdTestUsingAssertNotNull(){
        StudentService studentService=new StudentService();

        Student student =new Student(1,"John");
        studentService.addStudent(student);

        Student actualObject=studentService.getStudentById(1);

        //assertNotNull(actualObject);

        //assertNotNull(actualObject, "The object is null");

        assertNotNull(actualObject, ()-> "The object is null");

    }
    @Test
    public void getStudentByIdTestUsingAssertEquals(){
        StudentService studentService=new StudentService();

        Student student =new Student(1,"John");
        studentService.addStudent(student);

        Student actualObject=studentService.getStudentById(1);

        //assertEquals(1,actualObject.getId());
        //assertEquals("John",actualObject.getName());
        //assertEquals(student,actualObject);

        //assertEquals(1,actualObject.getId(), "Id does not match");

        assertEquals(2,actualObject.getId(), ()->"Id does not match");
    }
    @Test
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void getStudentByIdTestUsingAssertNotEquals(int id){
        StudentService studentService=new StudentService();

        Student student =new Student(id,"John");
        studentService.addStudent(student);

        Student actualObject=studentService.getStudentById(id);

        //assertNotEquals(1,actualObject.getId());
        //assertNotEquals("John",actualObject.getName());
        //assertNotEquals(student,actualObject);

        assertNotEquals(1,actualObject.getId(), "Stduent Id is equal");

        //assertNotEquals(1,actualObject.getId(), ()->"Stduent Id is equal");
    }

    @Test
    public void getStudentByIdTestUsingAssertThrows() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "John");
        studentService.addStudent(student);

        //studentService.getStudentById(1);

        StudentNotFoundException exception = assertThrows(StudentNotFoundException.class, () -> studentService.getStudentById(2));
        assertEquals("Student with id 2 not found", exception.getMessage());
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/login.csv", numLinesToSkip = 1)
//    @CsvSource({
//            "admin,password,true",
//            "admin,wrongpassword,false",
//            "user,password,false",
//            "guest,guest123,false"
//    })
    public void testLogin(String username,String password, boolean expectedResut){
        StudentService studentService = new StudentService();
        boolean actualResult=studentService.login(username,password);
        assertEquals(expectedResut, actualResult, "Login test failed for "+username+" and "+password);
    }

    @Test
    public void testLowerBoundary(){
        StudentService studentService=new StudentService();
        assertTrue(studentService.isValidAge(18), "Age 18 should be valid");
        assertFalse(studentService.isValidAge(17), "Age 17 should be invalid");

    }
    @Test
    public void testUpperBoundary(){
        StudentService studentService=new StudentService();
        assertTrue(studentService.isValidAge(30), "Age 30 should be valid");
        assertFalse(studentService.isValidAge(31), "Age 31 should be invalid");

    }
    @Test
    public void testMiddleValue(){
        StudentService studentService=new StudentService();
        assertTrue(studentService.isValidAge(20), "Age 20 should be valid");

    }

    @Test
    void testInvalidAge(){
        StudentService studentService=new StudentService();
        assertFalse(studentService.isValidAge(-1), "Negative age should be invalid");
        assertFalse(studentService.isValidAge(0), "Age 0 should be invalid");
        assertFalse(studentService.isValidAge(200), "Age 200 should be invalid");
    }
}