package com.tekina.company;

public class Employee {

    /*
        Generated Fields:
        - employeeId

        Mandatory Fields:
        - name
        - age
        - department
        - salary

        Optional Fields:
        - idCard

        Mutable Fields:
        - name
        - department
        - salary
        - idCard

        Immutable Fields:
        - employeeId

        Relationship:
        - Employee HAS IDCard (Composition)

        Why?
        - IDCard exists only for an employee.
    */

    private static int counter = 1;

    private final int employeeId;
    private String name;
    private int age;
    private String department;
    private double salary;

    private IDCard idCard;

    public Employee(String name,
                    int age,
                    String department,
                    double salary) {

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Invalid name");

        if (age < 18)
            throw new IllegalArgumentException("Employee must be adult.");

        if (department == null || department.isBlank())
            throw new IllegalArgumentException("Department required.");

        if (salary < 0)
            throw new IllegalArgumentException("Salary cannot be negative.");

        this.employeeId = counter++;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void assignIdCard(IDCard card) {
        this.idCard = card;
    }

    public void removeIdCard() {

        if (idCard != null) {
            idCard.deactivate();
            idCard = null;
        }
    }

    public void updateSalary(double salary) {

        if (salary < 0) {
            System.out.println("Invalid salary.");
            return;
        }

        this.salary = salary;
    }

    public void changeDepartment(String department) {

        if (department == null || department.isBlank()) {
            System.out.println("Invalid department.");
            return;
        }

        this.department = department;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "id=" + employeeId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", idCard=" + (idCard == null ? "Not Issued" : idCard.getCardNumber()) +
                '}';
    }
}