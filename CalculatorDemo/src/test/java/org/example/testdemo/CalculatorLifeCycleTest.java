package org.example.testdemo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorLifeCycleTest {

    static Calculator calc;

    @BeforeAll
    static void beforeAll(){
        calc=new Calculator();
        System.out.println("BeforeAll-calculator initialized");
    }


    @BeforeEach
    void beforeEach(TestInfo info)
    {
        //calc=new Calculator();
        System.out.println("BeforEach");
    }


    @Test
    void testAdd(){
        //Calculator calc=new Calculator();
        System.out.println("TestAdd");
        int a=2;
        int b=3;
        int expected=5;
        int actual=calc.add(a,b);
        assertEquals(5,actual);
    }

    @Test
    void testSubtract(){
        //Calculator calc=new Calculator();
        System.out.println("TestSubtract");
        int a=2;
        int b=3;
        int expected=5;
        int actual=calc.subtract(a,b);
        assertEquals(-1,actual);
    }
    @Test
    void testMultiply(){
        //Calculator calc=new Calculator();
        System.out.println("TestMultiply");
        int a=2;
        int b=3;
        int expected=5;
        int actual=calc.multiply(a,b);
        assertEquals(6,actual);
    }

    @AfterEach
    void afterEach(TestInfo info){
        //calc=null;
        System.out.println("AfterEach");
    }

    @AfterAll
    static void afterAll(){
        calc=null;
        System.out.println("AfterAll - Calculator released");
    }
}
