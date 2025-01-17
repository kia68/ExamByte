package com.example.exambyte.applicationService.serviceRepository;

import com.example.exambyte.domainLayer.model.exam.Aufgabe;

import java.util.List;
import java.util.UUID;

public interface AufgabenRepository {
    Aufgabe save(Aufgabe aufgabe);
    Aufgabe findById(UUID id);
    List<Aufgabe> findAll();
    void delete(Aufgabe aufgabe);
}
