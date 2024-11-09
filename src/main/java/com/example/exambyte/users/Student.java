package com.example.exambyte.users;

import com.example.exambyte.Email;
import com.example.exambyte.test.Test;

import java.util.List;

public class Student extends User{
    private List<Test> tests;

    public Student(Email email, Role role) {
        super(email, role);
    }

    public boolean isPassed(Test test){

        return false;
    }
}
