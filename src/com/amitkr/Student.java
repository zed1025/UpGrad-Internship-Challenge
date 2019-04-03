package com.amitkr;

public class Student {
    private String name;
    private double CGPA;
    private int token;

    Student(String n, double c, int t) {
        this.name = n;
        this.CGPA = c;
        this.token = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(float CGPA) {
        this.CGPA = CGPA;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }
}
