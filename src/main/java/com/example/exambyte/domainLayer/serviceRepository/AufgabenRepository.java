package com.example.exambyte.domainLayer.serviceRepository;

import com.example.exambyte.domainLayer.model.Aufgabe;

import java.util.List;

public interface AufgabenRepository {
    Aufgabe save(Aufgabe aufgabe);
    Aufgabe findById(Long id);
    List<Aufgabe> findAll();
    void delete(Aufgabe aufgabe);
}
