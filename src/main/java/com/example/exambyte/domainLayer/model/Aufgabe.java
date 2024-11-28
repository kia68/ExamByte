package com.example.exambyte.domainLayer.model;

public class Aufgabe {

    private String title;
    //private String type;
    private double punkt;
//    private String answerOption;

    public Aufgabe(String title, double punkt) {
        this.title = title;
        this.punkt = punkt;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPunkt() {
        return punkt;
    }

    public void setPunkt(double punkt) {
        this.punkt = punkt;
    }

    public String getType() {
        return null;
    }
}
