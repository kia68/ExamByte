package com.example.exambyte.service;

import com.example.exambyte.repositories.AufgabenRepo;
import com.example.exambyte.repositories.TestRepo;
import com.example.exambyte.repositories.UserRepo;
import com.example.exambyte.test.Aufgaben;
import com.example.exambyte.test.Test;
import com.example.exambyte.users.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepo testRepo;
    private final AufgabenRepo aufgabenRepo;
    private final UserRepo userRepo;


    public TestService(TestRepo testRepo, AufgabenRepo aufgabenRepo, UserRepo userRepo) {
        this.testRepo = testRepo;
        this.aufgabenRepo = aufgabenRepo;
        this.userRepo = userRepo;
    }

    public List<User> userList(){
        return userRepo.findAll();
    }
    public void addTest(Test test){
        testRepo.save(test);
    }
    public List<Test> getTests(){
        return testRepo.findAll();
    }
    public List<Aufgaben> getAufgaben(){
        return aufgabenRepo.findAll();
    }
}
