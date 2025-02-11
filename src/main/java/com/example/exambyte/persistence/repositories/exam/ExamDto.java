package com.example.exambyte.persistence.repositories.exam;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;
@Table("exam")
public record ExamDto(@Id Integer id,
                      UUID fachId,
                      String name,
                      LocalDateTime startTime,
                      LocalDateTime endTime
                      ) {

}
