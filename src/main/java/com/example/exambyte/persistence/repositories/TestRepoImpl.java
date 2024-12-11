package com.example.exambyte.persistence.repositories;

import com.example.exambyte.domainLayer.model.Test;
import com.example.exambyte.domainLayer.serviceRepository.TestRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TestRepoImpl implements TestRepository {
    List<Test> testList = new ArrayList<>();

    @Override
    public List<Test> findAll() {return testList;}
    @Override
    public void save(Test test){
        testList.add(test);
    }

    @Override
    public void deleteTest(Test test){
        testList.remove(test);
    }

}
