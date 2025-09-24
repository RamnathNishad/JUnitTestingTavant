package org.example.testdemo;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        return a / b;
    }

    public int stringLenth(String s) {
        return s.length();
    }

    public boolean isPalindrome(String word){
        return new StringBuilder(word).reverse().toString().equals(word);
    }
}
