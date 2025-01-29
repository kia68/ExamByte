package com.example.exambyte.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AntwortDataRepository extends CrudRepository<AntwortDto, Integer> {
    List<AntwortDto> findAll();

    AntwortDto save(AntwortDto antwortDto);

    Optional<AntwortDto> findByFachId(UUID uuid);
}
