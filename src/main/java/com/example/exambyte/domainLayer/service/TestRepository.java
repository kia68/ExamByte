package com.example.exambyte.domainLayer.service;

import com.example.exambyte.domainLayer.model.Test;

import java.util.List;

public interface TestRepository {


    public void save(Test test);
    public List<Test> findAll();

    public void deleteTest(Test test);
}
