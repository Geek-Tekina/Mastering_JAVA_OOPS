package com.tekina.oops;

public class Intern extends Employee {

    private int internshipDuration; // days

    public Intern(String name,
                  String gender,
                  String phoneNumber,
                  String address,
                  int age,
                  int internshipDuration) {

        super(name, gender, phoneNumber, address, age, 240000);

        if (internshipDuration <= 0) {
            throw new IllegalArgumentException(
                    "Internship duration must be positive."
            );
        }

        this.internshipDuration = internshipDuration;
    }

    public Intern(String name,
                  String gender,
                  int age) {

        this(name, gender, null, null, age, 60);
    }

    public void extendInternship(int extraDays) {

        if (extraDays <= 0) {
            System.out.println("Extra days must be positive.");
            return;
        }

        internshipDuration += extraDays;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.05;
    }

    @Override
    public String toString() {
        return "Intern{" +
                super.toString() +
                ", Internship Duration=" + internshipDuration + " days" +
                '}';
    }
}