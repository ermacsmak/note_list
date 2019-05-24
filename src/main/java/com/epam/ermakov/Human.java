package com.epam.ermakov;

public abstract class Human {
    private String surname, name, year, phone;

    public Human(String surname, String name, String year, String phone) {
        this.surname = surname;
        this.name = name;
        this.year = year;
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getYear() {
        return year;
    }
    public String getPhone() {
        return phone;
    }
}
