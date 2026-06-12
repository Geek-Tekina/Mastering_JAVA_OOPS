package com.tekina.oops;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee developer = new Developer(
                "Hemant",
                "Male",
                26,
                Arrays.asList("Java", "Spring Boot", "SQL")
        );

        Employee manager = new Manager(
                "Surendra",
                "Male",
                45,
                60
        );

        Employee intern = new Intern(
                "Satya",
                "Female",
                23
        );

        List<Employee> employees = Arrays.asList(
                developer,
                manager,
                intern
        );

        for (Employee employee : employees) {

            System.out.println(employee);

            System.out.println(
                    "Bonus: " + employee.calculateBonus()
            );

            System.out.println("--------------------------------");
        }
    }
}