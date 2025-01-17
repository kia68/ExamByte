package com.example.exambyte.domainLayer.model.exam;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Exam {

    @Id
    private UUID id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Aufgabe> aufgabe = new ArrayList<>();

    public Exam(
                String name,
                LocalDateTime startTime,
                LocalDateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Aufgabe> getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(List<Aufgabe> aufgabe) {
        this.aufgabe = aufgabe;
    }

    public UUID getId() {
        return id;
    }


}
