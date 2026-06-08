package com.tekina.studentManagement;

public class Student {
    /*
     * Generated Fields:
     * - studentId
     *
     * Mandatory Fields:
     * - name
     * - age
     *
     * Optional Fields:
     * - department
     * - cgpa
     */
    private static int numberOfStudent;
    private final int studentId;
    private String name;
    private int age;
    private String department;
    private double cgpa;

    public Student(String name, int age, String department, double cgpa){
        if(age < 0) {
            throw new IllegalArgumentException(
                    "Age cannot be negative"
            );
        }

        if(cgpa < 0 || cgpa > 10) {
            throw new IllegalArgumentException(
                    "CGPA must be between 0 and 10"
            );
        }

        numberOfStudent += 1;
        this.studentId = numberOfStudent;
        this.name = name;
        this.age = age;
        this.department = department;
        this.cgpa = cgpa;
    }

    public Student(String name, int age, String department){
        this(name, age, department, 0.0);
    }

    public Student(String name, int age){
        this(name, age, "Not Assigned", 0.0);
    }

    public void updateCgpa(double cgpa){
        if(cgpa >= 0 && cgpa <= 10){
            this.cgpa = cgpa;
        }else{
            System.out.println("CGPA must be between 0 and 10");
        }
    }

    public void changeDepartment(String department){
        this.department = department;
    }

    public void promoteStudent(){
        System.out.println("Student promoted to next semester");
    }
    @Override
    public String toString(){
        return ("Student Id" + this.studentId + "| Student Name : " + this.name + "| Student Age : " + this.age + "| Student Department : " + this.department
                + "| Student CGPA : " + this.cgpa
        );
    }

}
