package com.example.exambyte.persistence.repositories;

import com.example.exambyte.applicationService.serviceRepository.ExamRepository;
import com.example.exambyte.domainLayer.model.exam.Exam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ExamRepoImpl implements ExamRepository {
    List<Exam> testList = new ArrayList<>();

    @Override
    public List<Exam> findAll() {return testList;}


    @Override
    public Exam findById(UUID id) {
        return testList.stream()
                .filter(exam -> exam.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Exam test){
        testList.add(test);
    }

    @Override
    public void deleteTest(Exam test){
        testList.remove(test);
    }

}
