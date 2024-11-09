package com.example.exambyte.users;

import com.example.exambyte.Email;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private long id;
    private String name;
    private Email email;
    private Role role;
    private @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, role);
    }

    public User(Email email, Role role) {
        this.email = email;
        this.role = role;
    }

    @Override
    public String toString() {
        return "{email=" + email.getEmailAdresse() +
                ", role=" + role.role() +
                '}';
    }
}
