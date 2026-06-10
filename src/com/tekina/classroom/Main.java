package com.tekina.classroom;

import com.tekina.studentManagement.Student;

public class Main {
    public static void main(String[] args) {
       Classroom classroom1 = new Classroom("Dr. Joesph Murphy", 150);
        Student student1 = new Student("Marry", 21);
        Student student2 = new Student("Harry", 22);

        classroom1.addStudent(student1);
        classroom1.addStudent(student2);

        System.out.println(classroom1);

        classroom1.displayAllStudents();

        int studentIdToRemove = student1.getStudentId();
        classroom1.removeStudent(studentIdToRemove);

        System.out.println(classroom1.getCurrentStrength());
    }
}
