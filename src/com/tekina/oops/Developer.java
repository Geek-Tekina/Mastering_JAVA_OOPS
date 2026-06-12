package com.tekina.oops;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee {

    private List<String> techStack;

    public Developer(String name,
                     String gender,
                     String phoneNumber,
                     String address,
                     int age,
                     List<String> techStack) {

        super(name, gender, phoneNumber, address, age, 400000);

        this.techStack = techStack == null
                ? new ArrayList<>()
                : new ArrayList<>(techStack);
    }

    public Developer(String name,
                     String gender,
                     int age,
                     List<String> techStack) {

        this(name, gender, null, null, age, techStack);
    }

    public void addTechnology(String technology) {
        if (technology != null && !technology.isBlank()) {
            techStack.add(technology);
        }
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.20;
    }

    @Override
    public String toString() {
        return "Developer{" +
                super.toString() +
                ", Tech Stack=" + techStack +
                '}';
    }
}