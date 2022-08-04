package com.company.model;

public abstract class Flower {

    private String name;
    private String color;
    private double price;
    private int freshnessLevel;
    private int stemLength;
    private int amount;

    public Flower(String name, String color, double price, int freshnessLevel, int stemLength, int amount) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public int getStemLength() {
        return stemLength;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", freshnessLevel=" + freshnessLevel +
                ", stemLength=" + stemLength +
                ", amount=" + amount +
                '}';
    }
}
