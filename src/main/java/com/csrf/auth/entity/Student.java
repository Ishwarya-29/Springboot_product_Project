package com.csrf.auth.entity;

public class Student {

 private int rollno;

    public Student(int rollno, String name, String department) {
        this.rollno = rollno;
        this.name = name;
        this.department = department;
    }

    private String name;
 private String department;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
