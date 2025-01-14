package com.example.exambyte.domainLayer.model;

import java.util.List;
import java.util.Objects;

public class Abgabe {

    private Long id;
    private User user;
    private Test test;
    private List<Aufgabe> aufgaben;
    private List<String> antworten;
    private boolean isSubmitted;

    public Abgabe(Long id, User user, Test test, List<Aufgabe> aufgaben, List<String> antworten, boolean isSubmitted) {
        this.id = id;
        this.user = user;
        this.test = test;
        this.aufgaben = aufgaben;
        this.antworten = antworten;
        this.isSubmitted = isSubmitted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Aufgabe> getAufgaben() {
        return aufgaben;
    }

    public void setAufgaben(List<Aufgabe> aufgaben) {
        this.aufgaben = aufgaben;
    }

    public List<String> getAntworten() {
        return antworten;
    }

    public void setAntworten(List<String> antworten) {
        this.antworten = antworten;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abgabe abgabe = (Abgabe) o;
        return isSubmitted == abgabe.isSubmitted && Objects.equals(id, abgabe.id) && Objects.equals(user, abgabe.user) && Objects.equals(test, abgabe.test) && Objects.equals(aufgaben, abgabe.aufgaben) && Objects.equals(antworten, abgabe.antworten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Abgabe{" +
                "id=" + id +
                ", user=" + user +
                ", test=" + test +
                ", aufgaben=" + aufgaben +
                ", antworten=" + antworten +
                ", isSubmitted=" + isSubmitted +
                '}';
    }
}
