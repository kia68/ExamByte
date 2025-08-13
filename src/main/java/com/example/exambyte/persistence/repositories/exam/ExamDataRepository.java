package com.example.exambyte.persistence.repositories.exam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExamDataRepository extends CrudRepository<ExamDto, UUID> {

    List<ExamDto> findAll();

    ExamDto save(ExamDto exam);

    ExamDto findByFachId(UUID id);
}
