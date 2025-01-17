package com.example.exambyte.applicationService;

import com.example.exambyte.applicationService.serviceRepository.AufgabenRepository;
import com.example.exambyte.applicationService.serviceRepository.ExamRepository;
import com.example.exambyte.applicationService.serviceRepository.UserRepository;
import com.example.exambyte.domainLayer.model.exam.Aufgabe;
import com.example.exambyte.domainLayer.model.exam.Exam;
import com.example.exambyte.domainLayer.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExamService {

    private final ExamRepository testRepo;
    private final AufgabenRepository aufgabenRepo;
    private final UserRepository userRepo;


    public ExamService(ExamRepository testRepo, AufgabenRepository aufgabenRepo, UserRepository userRepo) {
        this.testRepo = testRepo;
        this.aufgabenRepo = aufgabenRepo;
        this.userRepo = userRepo;
    }

    public List<User> userList(){
        return userRepo.findAll();
    }
    public void addTest(Exam test){
        testRepo.save(test);
    }
    public List<Exam> getTests(){
        return testRepo.findAll();
    }
    public List<Aufgabe> getAufgaben(){
        return aufgabenRepo.findAll();
    }

    public void addAufgabe(Aufgabe aufgabe) {
        aufgabenRepo.save(aufgabe);
    }

    public Exam getTestById(UUID id) {
        return testRepo.findById(id);
    }

    public Aufgabe getAufgabeById(UUID id) {
        return aufgabenRepo.findById(id);
    }

    public void updateAufgabe(Aufgabe aufgabe) {
        aufgabenRepo.save(aufgabe);
    }

    public void deleteAufgabeById(UUID id) {
        Aufgabe a = aufgabenRepo.findById(id);
        aufgabenRepo.delete(a);
    }
}
