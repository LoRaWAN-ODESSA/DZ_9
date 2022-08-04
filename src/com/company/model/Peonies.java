package com.company.model;

public class Peonies extends Flower {

    private boolean isClosed;

    public Peonies(String name, String color, double price, int freshnessLevel, int stemLength, int amount, boolean isClosed) {
        super(name, color, price, freshnessLevel, stemLength, amount);
        this.isClosed = isClosed;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
