package com.example.exambyte.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExamDataRepository extends CrudRepository<ExamDto, Integer> {

    List<ExamDto> findAll();

    ExamDto save(ExamDto exam);

    Optional<ExamDto> findByFachId(UUID id);
}
