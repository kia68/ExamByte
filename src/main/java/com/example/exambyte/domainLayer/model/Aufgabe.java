package com.example.exambyte.domainLayer.model;


public class Aufgabe {
    private int id;
    private String title;
    private Integer punkt;
    private String type;
    private String aufgabe;
    private String antwort;

    public Aufgabe(String title, Integer punkt, String type, String aufgabe) {
        this.title = title;
        this.punkt = punkt;
        this.type = type;
        this.aufgabe = aufgabe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPunkt() {
        return punkt;
    }

    public void setPunkt(Integer punkt) {
        this.punkt = punkt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        this.aufgabe = aufgabe;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }
}
