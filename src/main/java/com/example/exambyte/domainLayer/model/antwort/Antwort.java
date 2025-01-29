package com.example.exambyte.domainLayer.model.antwort;


import java.util.UUID;

public class Antwort {

    //github users
    private UUID antwortId;
    private UUID aufgabeId;

    private  String githubUser;
    private String antwortText;

    public Antwort(UUID aufgabeId, String githubUser, String antwortText) {
        this.antwortId = UUID.randomUUID();
        this.aufgabeId = aufgabeId;
        this.githubUser = githubUser;
        this.antwortText = antwortText;
    }

    public UUID getAntwortId() {
        return antwortId;
    }

    public void setAntwortId(UUID antwortId) {
        this.antwortId = antwortId;
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


}
