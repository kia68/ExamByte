package com.example.exambyte.repositories;

import com.example.exambyte.test.Aufgaben;
import com.example.exambyte.test.Test;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AufgabenRepo {
    List<Aufgaben> aufgabenList = new ArrayList<>();

    public List<Aufgaben> findAll() {
        return aufgabenList;
    }

    public void save(Aufgaben aufgabe) {
        aufgabenList.add(aufgabe);
    }

    public void delete(Aufgaben aufgabe) {
        aufgabenList.remove(aufgabe);
    }
}
