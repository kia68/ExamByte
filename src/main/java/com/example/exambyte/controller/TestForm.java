package com.example.exambyte.controller;

public class TestForm {
    //id löschen
    private String name;
    private Integer aufgaben;

    public TestForm(String name, Integer aufgabens) {
        this.name = name;
        this.aufgaben = aufgabens;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAufgaben() {
        return aufgaben;
    }

    public void setAufgaben(Integer aufgaben) {
        this.aufgaben = aufgaben;
    }
}
