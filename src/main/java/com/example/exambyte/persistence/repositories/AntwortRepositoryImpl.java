package com.example.exambyte.persistence.repositories;

import com.example.exambyte.applicationService.serviceRepository.AntwortRepository;
import com.example.exambyte.domainLayer.model.antwort.Antwort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public class AntwortRepositoryImpl implements AntwortRepository {
    List<Antwort> antwortList = new ArrayList<>();

    @Override
    public List<Antwort> findAll() {
        return antwortList;
    }

    @Override
    public Antwort findById(UUID antwortId) {
        return antwortList
                .stream()
                .filter(a->a.getAntwortId().equals(antwortId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Antwort antwort) {
        antwortList.add(antwort);
    }

    @Override
    public void delete(Antwort antwort) {
        antwortList.remove(antwort);
    }

    @Override
    public List<Antwort> findByGithubLogin(String gitHubLogin) {
        return antwortList.stream()
                .filter(a->a.getGithubUser().equals(gitHubLogin))
                .toList();
    }

}
