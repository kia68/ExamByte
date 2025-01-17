package com.example.exambyte.domainLayer.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private Email email;
    private @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate birthday;



    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public User(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{email=" + email.getEmailAdresse() +
                ", role=" +
                '}';
    }
}
