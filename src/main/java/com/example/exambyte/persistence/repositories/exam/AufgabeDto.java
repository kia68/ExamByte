package com.example.exambyte.persistence.repositories.exam;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("aufgabe")
public record AufgabeDto(@Id UUID id,
                         UUID examId,
                         String title,
                         Integer punkt,
                         String type,
                         String beschreibung) {
}
