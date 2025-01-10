package com.example.exambyte.domainLayer.model;

import java.time.LocalDateTime;

public class Test {

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Aufgabe aufgabens;

    public Test(String name, LocalDateTime startTime, LocalDateTime endTime, Aufgabe aufgabens) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.aufgabens = aufgabens;
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

    public Aufgabe getAufgabens() {
        return aufgabens;
    }

    public void setAufgabens(Aufgabe aufgabens) {
        this.aufgabens = aufgabens;
    }
}
