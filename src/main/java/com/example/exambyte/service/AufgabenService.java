package com.example.exambyte.service;

import com.example.exambyte.test.Aufgaben;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AufgabenService {

    //aufgabenForm hier
    List<Aufgaben> aufgabenList = new ArrayList<>();

    private void addAufgabe(Aufgaben aufgaben) {
        aufgabenList.add(aufgaben);
    }

    public List<Aufgaben> getAllAufgaben() {
        return aufgabenList;
    }
    private void deleteAufgabe(Aufgaben aufgaben) {
        aufgabenList.remove(aufgaben);
    }

}
