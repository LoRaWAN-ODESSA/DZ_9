package com.company.model;

public class Lily extends Flower {

    private int size;

    public Lily(String name, String color, double price, int freshnessLevel, int stemLength, int amount, int size) {
        super(name, color, price, freshnessLevel, stemLength, amount);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
