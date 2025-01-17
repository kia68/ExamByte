package com.example.exambyte.controller;

public class AufgabenForm {
    private String title;
    private Integer punkt;
    private String type;
    private String beschreibung;


    public AufgabenForm(String title, Integer punkt, String type, String beschreibung) {
        this.title = title;
        this.punkt = punkt;
        this.type = type;
        this.beschreibung = beschreibung;
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

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
