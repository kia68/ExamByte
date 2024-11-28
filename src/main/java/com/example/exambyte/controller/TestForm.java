package com.example.exambyte.controller;

public class TestForm {
    private Integer id;
    private String name;
    private Integer aufgabens;

    public TestForm(Integer id, String name, Integer aufgabens) {
        this.id = id;
        this.name = name;
        this.aufgabens = aufgabens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAufgabens() {
        return aufgabens;
    }

    public void setAufgabens(Integer aufgabens) {
        this.aufgabens = aufgabens;
    }
}
