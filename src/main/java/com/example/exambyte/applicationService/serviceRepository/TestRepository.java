package com.example.exambyte.applicationService.serviceRepository;

import com.example.exambyte.domainLayer.model.Test;

import java.util.List;

public interface TestRepository {


    Test findById(int id);

    public void save(Test test);
    public List<Test> findAll();
    public void deleteTest(Test test);
}
