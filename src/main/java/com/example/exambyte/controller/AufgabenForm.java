package com.example.exambyte.controller;

import java.util.UUID;

public class AufgabenForm {
    private UUID id;
    private UUID examId;
    private String title;
    private Integer punkt;
    private String type;
    private String loesung;
    private String optionen;
    private String erklaerung;
    private String beschreibung;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getExamId() {
        return examId;
    }

    public void setExamId(UUID examId) {
        this.examId = examId;
    }

    public String getLoesung() {
        return loesung;
    }

    public void setLoesung(String loesung) {
        this.loesung = loesung;
    }

    public String getOptionen() {
        return optionen;
    }

    public void setOptionen(String optionen) {
        this.optionen = optionen;
    }

    public String getErklaerung() {
        return erklaerung;
    }

    public void setErklaerung(String erklaerung) {
        this.erklaerung = erklaerung;
    }
}
