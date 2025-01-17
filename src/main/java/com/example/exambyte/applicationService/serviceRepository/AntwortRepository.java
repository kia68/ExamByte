package com.example.exambyte.applicationService.serviceRepository;

import com.example.exambyte.domainLayer.model.antwort.Antwort;

import java.util.List;
import java.util.UUID;

public interface AntwortRepository {


    Antwort findById(UUID id);

    public void save(Antwort antwort);
    public List<Antwort> findAll();
    public void deleteTest(Antwort antwort);
}
