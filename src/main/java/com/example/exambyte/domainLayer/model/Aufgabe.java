package com.example.exambyte.domainLayer.model;

public class Aufgabe {

    private String title;
    private double punkt;

    private String type;
//    private String answerOption;
    public Aufgabe(String title, double punkt, String type) {
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

    public double getPunkt() {
        return punkt;
    }

    public void setPunkt(double punkt) {
        this.punkt = punkt;
    }

    public String getType() {
        return null;
    }

    public void setType(String type) {
        this.type = type;
    }

}
