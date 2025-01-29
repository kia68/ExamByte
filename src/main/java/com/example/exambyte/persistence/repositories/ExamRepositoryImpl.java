package com.example.exambyte.persistence.repositories;

import com.example.exambyte.applicationService.serviceRepository.ExamRepository;
import com.example.exambyte.domainLayer.model.exam.Exam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class  ExamRepositoryImpl implements ExamRepository {
    List<Exam> examList = new ArrayList<>();

    @Override
    public List<Exam> findAll() {return examList;}


    @Override
    public Exam findById(UUID id) {
        return examList.stream()
                .filter(exam -> exam.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //inn save muss man fachlicheID speichern
    @Override
    public void save(Exam exam){
        examList.removeIf(existingExam -> existingExam.getId().equals(exam.getId()));
        examList.add(exam);
    }

    @Override
    public void deleteTest(Exam test){
        examList.remove(test);
    }

}
