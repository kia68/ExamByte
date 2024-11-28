package com.example.exambyte.domainLayer.model;

public class TextAufgaben extends Aufgabe {

    private String correctAntwort;

    private double punkt;
    public TextAufgaben(String title, double punkt,String correctAntwort) {
        super(title, punkt);
        this.correctAntwort = correctAntwort;
    }

    @Override
    public String getType() {
        return "Text";
    }


    public String getCorrectAntwort() {
        return correctAntwort;
    }

    public void setCorrectAntwort(String correctAntwort) {
        this.correctAntwort = correctAntwort;
    }

}
