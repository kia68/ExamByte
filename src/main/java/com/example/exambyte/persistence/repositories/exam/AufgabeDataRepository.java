package com.example.exambyte.persistence.repositories.exam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface AufgabeDataRepository extends CrudRepository<AufgabeDto, UUID> {
    List<AufgabeDto> findAll();

    AufgabeDto save(AufgabeDto aufgabeDto);

    List<AufgabeDto> findByExamId(UUID examId);
}
