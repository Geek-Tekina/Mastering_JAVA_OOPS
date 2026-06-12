package com.tekina.oops;

public class Manager extends Employee {

    private int teamSize;

    public Manager(String name,
                   String gender,
                   String phoneNumber,
                   String address,
                   int age,
                   int teamSize) {

        super(name, gender, phoneNumber, address, age, 800000);

        if (teamSize < 0) {
            throw new IllegalArgumentException("Team size cannot be negative.");
        }

        this.teamSize = teamSize;
    }

    public Manager(String name,
                   String gender,
                   int age,
                   int teamSize) {

        this(name, gender, null, null, age, teamSize);
    }

    public void increaseTeamSize() {
        teamSize++;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.30;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                ", Team Size=" + teamSize +
                '}';
    }
}