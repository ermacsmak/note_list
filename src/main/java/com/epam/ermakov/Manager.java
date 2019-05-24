package com.epam.ermakov;

public class Manager extends Human {
    private String department;

    public Manager(String surname, String name, String phone, String year, String department) {
        super(surname, name, phone, year);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return "Отнюдь не бедный " + getSurname() + " " + getName()+ " " + getYear() + " " + getPhone()+ " " + department;
    }
}