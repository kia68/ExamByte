package com.example.exambyte.domainLayer.model.exam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Exam {


    private UUID fachId;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Aufgabe> aufgabe;

    public Exam(UUID id,
                String name,
                LocalDateTime startTime,
                LocalDateTime endTime
                ) {
        this.fachId = id != null ? id : UUID.randomUUID();
        this.name = name;
        this.startTime = startTime;
        this.aufgabe = aufgabe;
    }
    public Exam(String name){
        this(UUID.randomUUID(), name,LocalDateTime.now(),LocalDateTime.now().plusWeeks(1));
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
        return startTime.plusWeeks(1);
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public List<Aufgabe> getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(List<Aufgabe> aufgabe) {
        this.aufgabe = aufgabe;
    }

    public UUID getFachId() {
        return fachId;
    }

}
