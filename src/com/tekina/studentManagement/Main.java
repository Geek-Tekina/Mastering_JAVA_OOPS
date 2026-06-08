package com.tekina.studentManagement;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Murphy", 20);
        Student student2 = new Student("Hans Zimmer", 41, "Music");
        Student student3 = new Student("Cooper", 45, "Astrophysics", 9.9);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        student2.updateCgpa(10.00);
        System.out.println(student2);

        student1.updateCgpa(11.90);

        student3.promoteStudent();
        Student student4 = new Student("Alex", -5, "Fruad", 12.9);
        Student student5 = new Student("Ben", 23, "CSE", 12.92);
    }
}
