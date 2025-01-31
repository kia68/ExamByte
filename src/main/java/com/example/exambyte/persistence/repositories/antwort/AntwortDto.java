package com.example.exambyte.persistence.repositories.antwort;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("antwort")
public record AntwortDto(@Id Integer id,
                         UUID fachId,
                         String inhalt) {
}
