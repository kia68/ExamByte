package com.example.exambyte.applicationService.serviceRepository;

import com.example.exambyte.domainLayer.model.exam.Exam;

import java.util.List;
import java.util.UUID;

public interface ExamRepository {


    Exam findById(UUID id);

    public void save(Exam test);
    public List<Exam> findAll();
    public void deleteTest(Exam exam);
}