package com.example.exambyte.controller;

public class AufgabenForm {
    private String titel;
    private double punkt;
    private String type;

    public AufgabenForm(String titel, double punkt, String type) {
        this.titel = titel;
        this.punkt = punkt;
        this.type = type;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public double getPunkt() {
        return punkt;
    }

    public void setPunkt(double punkt) {
        this.punkt = punkt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
