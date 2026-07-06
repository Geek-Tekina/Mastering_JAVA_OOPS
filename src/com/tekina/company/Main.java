package com.tekina.company;

public class Main {

    public static void main(String[] args) {

        Company company = new Company("Tekina");

        Employee e1 =
                new Employee(
                        "Aniket",
                        24,
                        "Backend",
                        1200000);

        Employee e2 =
                new Employee(
                        "Murphy",
                        30,
                        "Architecture",
                        2500000);

        Employee e3 =
                new Employee(
                        "Hans",
                        40,
                        "Music",
                        900000);

        company.hireEmployee(e1);
        company.hireEmployee(e2);
        company.hireEmployee(e3);

        System.out.println("Employees:");

        company.displayEmployees();

        System.out.println();

        e1.updateSalary(1500000);

        e2.changeDepartment("Platform");

        company.removeEmployee(e3.getEmployeeId());

        System.out.println("After Updates:");

        company.displayEmployees();

        System.out.println();

        System.out.println("Employee Count : "
                + company.getEmployeeCount());
    }
}