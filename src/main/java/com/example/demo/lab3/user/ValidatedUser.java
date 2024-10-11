package com.example.demo.lab3.user;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class ValidatedUser {
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
