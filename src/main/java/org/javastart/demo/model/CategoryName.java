package org.javastart.demo.model;

public enum CategoryName {
    DESERT("Deser"),
    FIRST("Danie pierwsze"),
    SECOND("Danie drugie"),
    MAIN("Danie glowne"),
    DRINK("Napoj"),
    SALAD("Salata");

    private final String name;

    CategoryName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
