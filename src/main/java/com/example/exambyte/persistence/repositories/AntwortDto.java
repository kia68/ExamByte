package com.example.exambyte.persistence.repositories;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public record AntwortDto(@Id Integer id,
                         UUID fachId,
                         String inhalt) {
}
