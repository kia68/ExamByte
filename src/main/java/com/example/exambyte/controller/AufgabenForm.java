package com.example.exambyte.controller;

public class AufgabenForm {
    private String title;
    private Integer punkt;
    private String type;
    private String aufgabe;
    public AufgabenForm(String title, Integer punkt, String type) {
        this.title = title;
        this.punkt = punkt;
        this.type = type;
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

}
