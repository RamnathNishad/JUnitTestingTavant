package org.example.testdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Operations Test \uD83D\uDE17")
class CalculatorTest {

    private Calculator calc= new Calculator();

    @DisplayName("Test Addition of two numbers \uD83D\uDE00")
    @ParameterizedTest
    @CsvSource({
        "2,3,5",
        "3,7,10",
        "10,20,30",
        "-5,5,0",
        "-10,-20,-30"
    })
    public void addTest(int a,int b,int expectedSum){

        int sum= calc.add(a,b);
        assertEquals(expectedSum,sum);
    }
    @DisplayName("Test Subtraction of two numbers $#&^")
    @Test
    public void addSubtract(){

        int result= calc.subtract(2,3);
        assertEquals(-1,result);
    }

    @DisplayName("Test Multiplication of two numbers")
    @Test
    public void addMulitply(){

        int result= calc.multiply(2,3);
        assertEquals(6,result);
    }

    @DisplayName("Test Division of two numbers")
    @Test
    public void addDivide(){

        int result= calc.divide(10,5);
        assertEquals(2,result);
    }

    @Test
    public void testDivideByZeroThrowsException(){
        ArithmeticException thrown=assertThrows(ArithmeticException.class,()-> calc.divide(10,0));
        assertEquals("/ by zero",thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "hello,5",
            "JUnit,5",
            "Java,4"
    })
    public void testStringLength(String word,int expectedLength){
        assertEquals(expectedLength,calc.stringLenth(word));
    }

    @ParameterizedTest
    @ValueSource(strings = {"madam","radar","level"})
    public void testPalindromewWords(String word){
        assertTrue(calc.isPalindrome(word),word + " should be a palindrome");
    }
}