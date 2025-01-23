package com.example.exambyte.applicationService;

import com.example.exambyte.applicationService.serviceRepository.ExamRepository;
import com.example.exambyte.domainLayer.model.exam.Aufgabe;
import com.example.exambyte.domainLayer.model.exam.Exam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExamService {

    private final ExamRepository examRepository;



    public ExamService(ExamRepository testRepo) {
        this.examRepository = testRepo;

    }

    public void addExam(Exam exam){
        examRepository.save(exam);
    }
    public List<Exam> getExam(){
        return examRepository.findAll();
    }
    public Exam getExamById(UUID id) {
        return examRepository.findById(id);
    }

    public void addAufgabeToExam(UUID examId, Aufgabe aufgabe) {
        Exam exam = examRepository.findById(examId);
        if (exam != null) {
            exam.getAufgabe().add(aufgabe);
            examRepository.save(exam);
        } else {
            throw new IllegalArgumentException("Exam not found with ID: " + examId);
        }
    }
    public Aufgabe getAufgabeById(UUID examId, UUID aufgabeId) {
        Exam exam = examRepository.findById(examId);
        Aufgabe aufgabe = exam.getAufgabe().stream()
                .filter(a->a.getId().equals(aufgabeId))
                .findFirst()
                .orElse(null);
        return aufgabe;
    }

    public void updateAufgabe(UUID examId, Aufgabe aufgabe) {
        Exam exam = examRepository.findById(examId);
        exam.getAufgabe().removeIf(a->a.getId().equals(aufgabe.getId()));
        exam.getAufgabe().add(aufgabe);
    }

    public void deleteAufgabeById(UUID examId, UUID aufgabeId) {
        Exam exam = examRepository.findById(examId);
        exam.getAufgabe().removeIf(a->a.getId().equals(aufgabeId));
    }

    public List<Aufgabe> getAufgaben(UUID examId){
        Exam exam = examRepository.findById(examId);
        return exam.getAufgabe();
    }

}
