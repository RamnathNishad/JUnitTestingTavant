package org.example.testdemo;

public class Student {

    private int Id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Student(int id, String name) {
        Id = id;
        this.name = name;
    }


}
