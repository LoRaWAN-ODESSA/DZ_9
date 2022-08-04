package com.company.model;

public class Rose extends Flower {

    private String type;

    public Rose(String name, String color, double price, int freshnessLevel, int stemLength, int amount, String type) {
        super(name, color, price, freshnessLevel, stemLength, amount);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
