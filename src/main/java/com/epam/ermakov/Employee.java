package com.epam.ermakov;

public class Employee extends Human {
    private String manager;

    public Employee(String surname, String name, String phone, String year, String manager) {
        super(surname, name, phone, year);
        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }

    public String toString() {
        return "Несчастный работник по имени " + getSurname() + " " + getName()+ " " + getYear() + " " + getPhone()+ " " + manager;
    }
}