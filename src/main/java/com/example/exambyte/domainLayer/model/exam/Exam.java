package com.example.exambyte.domainLayer.model.exam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Exam {

    private UUID examId;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime publishDate;
    private List<Aufgabe> aufgabe;

    public Exam(UUID id,
            String name,
            LocalDateTime startTime,
            LocalDateTime endTime,
            LocalDateTime publishDate,
            List<Aufgabe> aufgabe) {
        this.examId = id != null ? id : UUID.randomUUID();
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.publishDate = publishDate;
        this.aufgabe = aufgabe != null ? aufgabe : new ArrayList<>();
    }

    public Exam(String name) {
        this(UUID.randomUUID(), name, LocalDateTime.now(), LocalDateTime.now().plusWeeks(1),
                LocalDateTime.now().plusWeeks(2), new ArrayList<>());
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

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isResultPublished() {
        return LocalDateTime.now().isAfter(publishDate);
    }

    public List<Aufgabe> getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(List<Aufgabe> aufgabe) {
        this.aufgabe = aufgabe;
    }

    public UUID getExamId() {
        return examId;
    }

}
