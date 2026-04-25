package models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class Book {
    private int id;

    @NotEmpty(message = "Название книги не может быть пустым")
    private String name;

    @NotEmpty(message = "Укажите автора")
    private String author;

    @NotEmpty(message = "Год не может быть пустым")
    @Pattern(regexp = "\\d{4}", message = "Год должен состоять из 4 цифр")
    private int age;

    public Book() {}

    public Book(int id, String name, String author, int age) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
