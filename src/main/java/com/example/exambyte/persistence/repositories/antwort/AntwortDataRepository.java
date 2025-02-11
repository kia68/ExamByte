package com.example.exambyte.persistence.repositories.antwort;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface AntwortDataRepository extends CrudRepository<AntwortDto, UUID> {
    List<AntwortDto> findAll();

    AntwortDto save(AntwortDto antwortDto);

    Optional<AntwortDto> findByFachId(UUID uuid);

//    @Query("SELECT * FROM antwort WHERE exam_id = :exam AND aufgabe_id = :aufgabe")
//    List<AntwortDto> findAllByExamAndAufgabe(@Param("exam") UUID exam,@Param("aufgabe") UUID aufgabe);
}
