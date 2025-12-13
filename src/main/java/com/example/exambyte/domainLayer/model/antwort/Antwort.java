package com.example.exambyte.domainLayer.model.antwort;

import java.util.UUID;

public class Antwort {

    private UUID fachId;
    private UUID aufgabeId;
    private String githubUser;
    private String antwortText;
    private Integer punkte;
    private String feedback;

    public Antwort(UUID aufgabeId, String githubUser, String antwortText) {
        this.fachId = UUID.randomUUID();
        this.aufgabeId = aufgabeId;
        this.githubUser = githubUser;
        this.antwortText = antwortText;
    }

    public Antwort(UUID fachId, UUID aufgabeId, String githubUser, String antwortText, Integer punkte,
            String feedback) {
        this.fachId = fachId;
        this.aufgabeId = aufgabeId;
        this.githubUser = githubUser;
        this.antwortText = antwortText;
        this.punkte = punkte;
        this.feedback = feedback;
    }

    public UUID getFachId() {
        return fachId;
    }

    public void setFachId(UUID fachId) {
        this.fachId = fachId;
    }

    public UUID getAufgabeId() {
        return aufgabeId;
    }

    public void setAufgabeId(UUID aufgabeId) {
        this.aufgabeId = aufgabeId;
    }

    public String getGithubUser() {
        return githubUser;
    }

    public void setGithubUser(String githubUser) {
        this.githubUser = githubUser;
    }

    public String getAntwortText() {
        return antwortText;
    }

    public void setAntwortText(String antwortText) {
        this.antwortText = antwortText;
    }

    public Integer getPunkte() {
        return punkte;
    }

    public void setPunkte(Integer punkte) {
        this.punkte = punkte;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
