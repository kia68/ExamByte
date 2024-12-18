package com.example.exambyte.applicationService;

import com.example.exambyte.applicationService.serviceRepository.AufgabenRepository;
import com.example.exambyte.applicationService.serviceRepository.TestRepository;
import com.example.exambyte.applicationService.serviceRepository.UserRepository;
import com.example.exambyte.domainLayer.model.Aufgabe;
import com.example.exambyte.domainLayer.model.Test;
import com.example.exambyte.domainLayer.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepo;
    private final AufgabenRepository aufgabenRepo;
    private final UserRepository userRepo;


    public TestService(TestRepository testRepo, AufgabenRepository aufgabenRepo, UserRepository userRepo) {
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
    public List<Aufgabe> getAufgaben(){
        return aufgabenRepo.findAll();
    }

    public void addAufgabe(Aufgabe aufgabe) {
        aufgabenRepo.save(aufgabe);
    }
}
