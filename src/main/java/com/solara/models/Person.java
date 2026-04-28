package com.solara.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class Person {
    private int id;

    @NotEmpty (message = "Фамилия не может быть пустым полем")
    private String surname;

    @NotEmpty (message = "Имя не может быть пустым полем")
    private String name;

    private String patonymic; //отчество

    @NotEmpty (message = "Год рождения не может быть пустым полем")
    @Pattern(regexp = "\\d{4}", message = "Год рождения должен состоять из 4 цифр")
    private int birthYear;

    public Person() {}

    public Person(int id, String surname, String name, String patonymic, int birthYear) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patonymic = patonymic;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatonymic() {
        return patonymic;
    }

    public void setPatonymic(String patonymic) {
        this.patonymic = patonymic;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
