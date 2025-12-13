package com.example.exambyte.applicationService;

import com.example.exambyte.applicationService.serviceRepository.AntwortRepository;
import com.example.exambyte.applicationService.serviceRepository.ExamRepository;
import com.example.exambyte.domainLayer.model.antwort.Antwort;
import com.example.exambyte.domainLayer.model.exam.Aufgabe;
import com.example.exambyte.domainLayer.model.exam.Exam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ExamService {

    private final ExamRepository examRepository;
    private final AntwortRepository antwortRepository;

    public ExamService(ExamRepository testRepo, AntwortRepository antwortRepository) {
        this.examRepository = testRepo;
        this.antwortRepository = antwortRepository;
    }

    public void addExam(Exam exam) {
        examRepository.save(exam);
    }
    // public Collection<Exam> getExam(){
    // return examRepository.findAll();
    // }

    public Collection<Exam> getExam() {
        return examRepository.findAll().stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Exam::getName, e -> e, (e1, e2) -> e1),
                        map -> new ArrayList<>(map.values())));
    }

    // public Map<String, List<Exam>> getGroupedExams() {
    // return examRepository.findAll().stream()
    // .collect(Collectors.groupingBy(Exam::getName));
    // }

    public Exam getExamById(UUID id) {
        return examRepository.findById(id);
    }

    public void addAufgabeToExam(UUID examId, Aufgabe aufgabe) {
        aufgabe.setExamId(examId);
        examRepository.saveAufgabe(aufgabe);
    }

    public Aufgabe getAufgabeById(UUID examId, UUID aufgabeId) {
        Exam exam = examRepository.findById(examId);
        Aufgabe aufgabe = exam.getAufgabe().stream()
                .filter(a -> a.getId().equals(aufgabeId))
                .findFirst()
                .orElse(null);
        return aufgabe;
    }

    public void updateAufgabe(UUID examId, Aufgabe aufgabe) {
        Exam exam = examRepository.findById(examId);
        exam.getAufgabe().removeIf(a -> a.getId().equals(aufgabe.getId()));
        exam.getAufgabe().add(aufgabe);
    }

    public void deleteAufgabeById(UUID examId, UUID aufgabeId) {
        Exam exam = examRepository.findById(examId);
        exam.getAufgabe().removeIf(a -> a.getId().equals(aufgabeId));
    }

    public List<Aufgabe> getAufgaben(UUID examId) {
        Exam exam = examRepository.findById(examId);
        return exam.getAufgabe();
    }

    public void submitAntwort(Antwort antwort) {
        // Auto-grading for Multiple Choice
        Aufgabe aufgabe = getAufgabeById(antwort.getFachId(), antwort.getAufgabeId());
        if (aufgabe != null && "Multiple-Choice".equalsIgnoreCase(aufgabe.getType())) {
            // Simple auto-grading: Exact match
            if (antwort.getAntwortText() != null && antwort.getAntwortText().equals(aufgabe.getLoesung())) {
                antwort.setPunkte(aufgabe.getPunkt());
            } else {
                antwort.setPunkte(0);
            }
        }
        antwortRepository.save(antwort);
    }

    public int getMaxPoints(UUID examId) {
        return getAufgaben(examId).stream()
                .mapToInt(a -> a.getPunkt() != null ? a.getPunkt() : 0)
                .sum();
    }

    public int getStudentPoints(UUID examId, String username) {
        return antwortRepository.findByGithubLogin(username).stream()
                .filter(a -> a.getFachId().equals(examId)) // Note: Antwort.fachId corresponds to Exam.examId
                .mapToInt(a -> a.getPunkte() != null ? a.getPunkte() : 0)
                .sum();
    }

    public boolean hasPassed(UUID examId, String username) {
        int maxPoints = getMaxPoints(examId);
        int studentPoints = getStudentPoints(examId, username);
        return studentPoints >= (maxPoints / 2.0);
    }

    public Antwort getAntwortForUser(UUID aufgabeId, String username) {
        return antwortRepository.findByAufgabeIdAndGithubUser(aufgabeId, username);
    }
}
