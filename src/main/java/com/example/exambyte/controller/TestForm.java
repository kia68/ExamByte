package com.example.exambyte.controller;

import com.example.exambyte.domainLayer.model.Aufgabe;

public class TestForm {
    private String name;
    private Aufgabe aufgaben;

    public TestForm(String name, Aufgabe aufgabens) {
        this.name = name;
        this.aufgaben = aufgabens;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Aufgabe getAufgaben() {
        return aufgaben;
    }

    public void setAufgaben(Aufgabe aufgaben) {
        this.aufgaben = aufgaben;
    }
}
