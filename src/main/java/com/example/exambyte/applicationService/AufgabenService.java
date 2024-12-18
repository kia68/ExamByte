package com.example.exambyte.applicationService;

import com.example.exambyte.applicationService.serviceRepository.AufgabenRepository;
import com.example.exambyte.domainLayer.model.Aufgabe;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AufgabenService {
    private final AufgabenRepository aufgabenRepo;
    public AufgabenService(AufgabenRepository aufgabenRepo) {
        this.aufgabenRepo = aufgabenRepo;
    }

    private Aufgabe addAufgabe(String titel, double punkt, String type) {
        Aufgabe aufgabe = new Aufgabe(titel, punkt, type);
        return aufgabenRepo.save(aufgabe);
    }

    public List<Aufgabe> getAllAufgaben() {
        return aufgabenRepo.findAll();
    }
    private void deleteAufgabe(Aufgabe aufgaben) {
        aufgabenRepo.delete(aufgaben);
    }
    public AufgabenRepository getAufgabenRepo() {
        return aufgabenRepo;
    }


}
