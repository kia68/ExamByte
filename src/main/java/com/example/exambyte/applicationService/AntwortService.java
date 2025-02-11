package com.example.exambyte.applicationService;

import com.example.exambyte.applicationService.serviceRepository.AntwortRepository;
import com.example.exambyte.domainLayer.model.antwort.Antwort;
import org.springframework.stereotype.Service;

@Service
public class AntwortService {
    private final AntwortRepository antwortRepository;

    public AntwortService(AntwortRepository antwortRepository) {
        this.antwortRepository = antwortRepository;
    }

    public void addAntwortToAufgabe(Antwort antwort){
        antwortRepository.save(antwort);
    }





}
