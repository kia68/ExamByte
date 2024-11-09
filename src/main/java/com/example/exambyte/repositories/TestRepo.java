package com.example.exambyte.repositories;

import com.example.exambyte.test.Test;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TestRepo {
    List<Test> testList = new ArrayList<>();

    public List<Test> findAll() {return testList;}
    public void save(Test test){

        testList.add(test);
    }

    private void deleteTest(Test test){
        testList.remove(test);
    }

}
