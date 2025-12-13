package com.example.exambyte.domainLayer.model.exam;

import java.util.UUID;

public class Aufgabe {

    private UUID id;
    private UUID examId;
    private String title;
    private Integer punkt;
    private String type;
    private String beschreibung;
    private String loesung;
    private String optionen;
    private String erklaerung;

    public Aufgabe(UUID id, UUID examId, String title, Integer punkt,
            String type, String beschreibung, String loesung, String optionen, String erklaerung) {
        this.id = id;
        this.examId = examId;
        this.title = title;
        this.punkt = punkt;
        this.type = type;
        this.beschreibung = beschreibung;
        this.loesung = loesung;
        this.optionen = optionen;
        this.erklaerung = erklaerung;
    }

    public Aufgabe(UUID id, UUID examId, String title, Integer punkt,
            String type, String beschreibung) {
        this(id, examId, title, punkt, type, beschreibung, null, null, null);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UUID getExamId() {
        return examId;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
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

    public void setExamId(UUID examId) {
        this.examId = examId;
    }
}
