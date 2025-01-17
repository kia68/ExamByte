package com.example.exambyte.domainLayer.model.antwort;

import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

public class Antwort {

    @Id
    private UUID id;

    private String antwortText;

    public Antwort(String antwortText) {
        this.antwortText = antwortText;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getAntwortText() {
        return antwortText;
    }

    public void setAntwortText(String antwortText) {
        this.antwortText = antwortText;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
