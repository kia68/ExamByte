package com.example.exambyte.persistence.repositories;

import com.example.exambyte.applicationService.serviceRepository.AufgabenRepository;
import com.example.exambyte.domainLayer.model.exam.Aufgabe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AufgabenRepoImpl implements AufgabenRepository {
    List<Aufgabe> aufgabenList = new ArrayList<>();

    @Override
    public List<Aufgabe> findAll() {
        return aufgabenList;
    }

    @Override
    public Aufgabe save(Aufgabe aufgabe) {
        aufgabenList.add(aufgabe);
        return aufgabe;
    }

    @Override
    public Aufgabe findById(UUID id) {
        return null;
    }

    @Override
    public void delete(Aufgabe aufgabe) {
        aufgabenList.remove(aufgabe);
    }
}
