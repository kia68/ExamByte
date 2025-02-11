package com.example.exambyte.applicationService.serviceRepository;

import com.example.exambyte.domainLayer.model.exam.Exam;

import java.util.Collection;
import java.util.UUID;

public interface ExamRepository {


    public Exam findById(UUID id);

    public void save(Exam exam);
    public Collection<Exam> findAll();
//    public void deleteTest(Exam exam);

}
