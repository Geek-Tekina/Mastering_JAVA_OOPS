package com.tekina.company;

import java.util.ArrayList;
import java.util.List;

public class Company {

    /*
        Generated Fields:
        - companyId

        Mandatory Fields:
        - companyName

        Optional Fields:
        - employees

        Mutable Fields:
        - employees

        Immutable Fields:
        - companyId

        Relationship:
        - Company HAS Employees (Aggregation)

        Why?
        - Employees exist independently.
    */

    private static int counter = 1;

    private final int companyId;

    private final String companyName;

    private final List<Employee> employees;

    public Company(String companyName) {

        if (companyName == null || companyName.isBlank())
            throw new IllegalArgumentException("Invalid company name.");

        this.companyId = counter++;
        this.companyName = companyName;
        this.employees = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {

        if (employee == null)
            return;

        employees.add(employee);

        issueIdCard(employee);
    }

    public void issueIdCard(Employee employee) {

        employee.assignIdCard(new IDCard());
    }

    public boolean removeEmployee(int employeeId) {

        Employee employee = findEmployee(employeeId);

        if (employee == null) {

            System.out.println("Employee not found.");
            return false;
        }

        employee.removeIdCard();

        employees.remove(employee);

        return true;
    }

    public Employee findEmployee(int employeeId) {

        for (Employee employee : employees) {

            if (employee.getEmployeeId() == employeeId)
                return employee;
        }

        return null;
    }

    public void displayEmployees() {

        for (Employee employee : employees) {

            System.out.println(employee);
        }
    }

    public int getEmployeeCount() {
        return employees.size();
    }
}