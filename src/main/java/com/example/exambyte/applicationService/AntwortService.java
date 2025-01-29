package com.example.exambyte.applicationService;

import com.example.exambyte.applicationService.serviceRepository.AntwortRepository;
import com.example.exambyte.domainLayer.model.antwort.Antwort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AntwortService {
    private final AntwortRepository antwortRepository;

    public AntwortService(AntwortRepository antwortRepository) {
        this.antwortRepository = antwortRepository;
    }

    public void addAntwortToAufgabe(UUID aufgabeId, String gitHublogin, Antwort antwort){
        Antwort antwort1 = new Antwort(aufgabeId, gitHublogin, antwort.getAntwortText());
        antwortRepository.save(antwort1);
    }





}
