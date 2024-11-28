package com.example.exambyte.domainLayer.model;

import java.util.List;

public class MultipleChoiceAufgabe extends Aufgabe {
    private  String correctAnswer;
    private List<String> options;
    private List<Aufgabe> correctOptions;

    public MultipleChoiceAufgabe(String title, double punkt, List<String> options, String correctAnswer) {
        super(title, punkt);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<Aufgabe> getCorrectOptions() {
        return correctOptions;
    }

    public void setCorrectOptions(List<Aufgabe> correctOptions) {
        this.correctOptions = correctOptions;
    }

    @Override
    public String getType() {
        return "MultipleChoice";
    }


}
