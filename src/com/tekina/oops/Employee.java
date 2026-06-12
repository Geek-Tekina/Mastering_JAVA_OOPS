package com.tekina.oops;

public abstract class Employee {

    /*
     * Generated Fields:
     * - employeeId
     * - employeeEmail
     *
     * Mandatory Fields:
     * - name
     * - gender
     * - age
     * - salary
     *
     * Optional Fields:
     * - phoneNumber
     * - address
     *
     * Mutable Fields:
     * - name
     * - gender
     * - phoneNumber
     * - address
     *
     * Immutable Fields:
     * - employeeId
     * - employeeEmail
     *
     * Relationship Type:
     * - Parent (Inheritance)
     */

    private static int nextEmployeeId = 1;

    private final int employeeId;
    private final String employeeEmail;

    private String name;
    private String gender;
    private String phoneNumber;
    private String address;
    private int age;

    private double salary;

    public Employee(String name,
                    String gender,
                    String phoneNumber,
                    String address,
                    int age,
                    double salary) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        if (gender == null || gender.isBlank()) {
            throw new IllegalArgumentException("Gender cannot be null or blank.");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Employee age cannot be less than 18.");
        }

        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        this.employeeId = nextEmployeeId++;

        this.employeeEmail = name
                .trim()
                .toLowerCase()
                .replace(" ", ".")
                + "@airbus.com";

        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    protected double getSalary() {
        return salary;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public void updateName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid name.");
            return;
        }

        this.name = name;
    }

    public abstract double calculateBonus();

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
                ", Name: " + name +
                ", Gender: " + gender +
                ", Age: " + age +
                ", Email: " + employeeEmail +
                ", Phone: " + phoneNumber +
                ", Address: " + address +
                ", Salary: " + salary;
    }
}