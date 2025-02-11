package com.example.exambyte.persistence.repositories.antwort;

import com.example.exambyte.applicationService.serviceRepository.AntwortRepository;
import com.example.exambyte.domainLayer.model.antwort.Antwort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public class AntwortRepositoryImpl implements AntwortRepository {
    private final AntwortDataRepository antwortDataRepository;

    public AntwortRepositoryImpl(AntwortDataRepository antwortDataRepository) {
        this.antwortDataRepository = antwortDataRepository;
    }

    @Override
    public List<Antwort> findAll() {
        return antwortDataRepository.findAll()
                .stream()
                .map(this::toAntwort)
                .toList();
    }

    private Antwort toAntwort(AntwortDto antwortDto) {
        return new Antwort(antwortDto.aufgabeId(), antwortDto.githubUser(), antwortDto.antwortText());
    }

    @Override
    public Antwort findById(UUID antwortId) {
        return antwortDataRepository
                .findByFachId(antwortId)
                .map(this::toAntwort)
                .orElse(null);
    }

    @Override
    public void save(Antwort antwort) {
        AntwortDto antwortDto = toAntwortDto(antwort);
        antwortDataRepository.save(antwortDto);
    }

    private AntwortDto toAntwortDto(Antwort antwort) {
        return new AntwortDto(null, antwort.getFachId(),antwort.getAufgabeId(), antwort.getGithubUser(), antwort.getAntwortText());
    }

//    @Override
//    public void delete(Antwort antwort) {
//        antwortDataRepository.findByFachId(antwort.getAntwortId());
//    }

    @Override
    public List<Antwort> findByGithubLogin(String gitHubLogin) {
        return antwortDataRepository.findAll()
                .stream().map(this::toAntwort)
                .filter(a->a.getGithubUser().equals(gitHubLogin))
                .toList();
    }

}
