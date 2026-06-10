package com.tekina.classroom;

import com.tekina.studentManagement.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Classroom {
    private static int id = 1;
    private final int classroomId;
    private String teacherName;
    private final int capacity;
    private List<Student> students;
    public Classroom(String teacherName, int capacity, List<Student> students){
        if(capacity < 0){
            throw new IllegalArgumentException("Can not have negative capacity for a classroom");
        }
        if(teacherName == null || teacherName.isBlank()){
            throw  new IllegalArgumentException("Teacher Name can not be empty.");
        }
        this.classroomId = id++;
        this.teacherName = teacherName;
        this.capacity = capacity;
        this.students =
                students == null
                        ? new ArrayList<>()
                        : new ArrayList<>(students);
    }

    public Classroom(String teacherName, int capacity){
        this(teacherName, capacity, null);
    }

    public boolean addStudent(Student student){
        if(this.students.size() >= this.capacity){
            System.out.println("Classroom is full.");
            return false;
        }
        return this.students.add(student);
    }

    public boolean removeStudent(int studentId){
        Student studentToRemove = null;
        for(Student student : this.students){
          if(student.getStudentId() == studentId){
              studentToRemove = student;
              break;
          }
        }
        if(studentToRemove == null){
            System.out.println("Can not find any student with this StudentId");
            return false;
        }
        return this.students.remove(studentToRemove);
    }

    public Student findStudentById(int studentId){
        Student studentToReturn = null;
        for(Student student : this.students){
            if(student.getStudentId() == studentId){
                studentToReturn = student;
                break;
            }
        }
        if(studentToReturn == null){
            System.out.println("Can not find any student with this StudendId");
            return studentToReturn;
        }
        return studentToReturn;
    }

    public void displayAllStudents(){
        for(Student student: this.students){
            System.out.println(student);
        }
    }

    public int getCurrentStrength(){
        return this.students.size();
    }

    @Override
    public String toString(){
        return ("Classroom Id : " + this.classroomId + "| Classroom Teacher's Name : " + this.teacherName
                + "| Classroom's Capacity" + this.capacity + "| Classroom's Students : " + this.students);
    }
}
