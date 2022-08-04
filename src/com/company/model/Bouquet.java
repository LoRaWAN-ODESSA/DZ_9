package com.company.model;

import java.util.Arrays;
import java.util.Scanner;

public class Bouquet {

    private int id;
    private Flower[] flowers;
    private Accessory[] accessories;
    private double totalPrice;

    public Bouquet(int id) {
        this.id = id;
        this.flowers = new Flower[0];
        this.accessories = new Accessory[0];
        this.totalPrice = 0.0;
    }


    public void addFlower(int type, int amount, String color, int freshnessLevel, int stemLength) {
        boolean correctInput = true;
        switch (type) {
            case 1:
                while (correctInput) {
                    System.out.print("Choose type of roses: 1. Memorial rose; 2. China rose: ");
                    String roseType = "";
                    int choice = getInputInt();
                    if (choice == 1) {
                        roseType = "Memorial rose";
                        double price = 2 * amount * ((double) stemLength / 2) * (2 / (double) freshnessLevel);
                        Rose result = new Rose(roseType, color, price, freshnessLevel, stemLength, amount, roseType);
                        updateFlowersList(result);
                        correctInput = false;
                    } else if (choice == 2) {
                        roseType = "China rose";
                        double price = 1.5 * amount * ((double) stemLength / 2) * (2 / (double) freshnessLevel);
                        Rose result = new Rose(roseType, color, price, freshnessLevel, stemLength, amount, roseType);
                        updateFlowersList(result);
                        correctInput = false;
                    } else {
                        System.out.println("Choose right type of roses (1 or 2).");
                    }
                }
                break;
            case 2:
                while (correctInput) {
                    System.out.print("Choose type of peonies: 1. Peonies (closed); 2. Peonies (opened): ");
                    boolean isOpened;
                    int choice = getInputInt();
                    if (choice == 1) {
                        isOpened = false;
                        double price = 1.7 * amount * ((double) stemLength / 2) * (2 / (double) freshnessLevel);
                        Peonies result = new Peonies("Peonies (closed)", color, price, freshnessLevel, stemLength, amount, isOpened);
                        updateFlowersList(result);
                        correctInput = false;
                    } else if (choice == 2) {
                        isOpened = true;
                        double price = 1.2 * amount * ((double) stemLength / 2) * (2 / (double) freshnessLevel);
                        Peonies result = new Peonies("Peonies (opened)", color, price, freshnessLevel, stemLength, amount, isOpened);
                        updateFlowersList(result);
                        correctInput = false;
                    } else {
                        System.out.println("Choose right type of peonies (1 or 2).");
                    }
                }
                break;
            case 3:
                while (correctInput) {
                    System.out.print("Choose type of lilies: 1. Lilies (big); 2. Lilies (small): ");
                    int liliesSize;
                    int choice = getInputInt();
                    if (choice == 1) {
                        liliesSize = 1;
                        double price = 1.3 * amount * ((double) stemLength / 2) * (2 / (double) freshnessLevel);
                        Lily result = new Lily("Lilies (big)", color, price, freshnessLevel, stemLength, amount, liliesSize);
                        updateFlowersList(result);
                        correctInput = false;
                    } else if (choice == 2) {
                        liliesSize = 2;
                        double price = 1.1 * amount * ((double) stemLength / 2) * (2 / (double) freshnessLevel);
                        Lily result = new Lily("Lilies (small)", color, price, freshnessLevel, stemLength, amount, liliesSize);
                        updateFlowersList(result);
                        correctInput = false;
                    } else {
                        System.out.println("Choose right type of lilies (1 or 2).");
                    }
                }
                break;
        }
    }

    public void addAccessory(int type) {
        switch (type) {
            case 1:
                updateAccessoryList(new Accessory("Bijouterie", 5.0));
                break;
            case 2:
                updateAccessoryList(new Accessory("Card", 2.0));
                break;
            case 3:
                updateAccessoryList(new Accessory("Baloons", 3.0));
                break;
            case 4:
                updateAccessoryList(new Accessory("Candies", 4.0));
                break;
        }
    }

    public void calculateTotalPrice() {
        double price = 0;
        for (int i = 0; i < flowers.length; i++) {
            price += flowers[i].getPrice();
        }
        for (int i = 0; i < accessories.length; i++) {
            price += accessories[i].getPrice();
        }
        this.totalPrice = price;
    }

    private void updateFlowersList(Flower flower) {
        if (flowers.length == 0) {
            flowers = new Flower[1];
            flowers[0] = flower;
        } else {
            Flower[] temp = new Flower[flowers.length + 1];
            for (int i = 0; i < flowers.length; i++) {
                temp[i] = flowers[i];
            }
            temp[flowers.length] = flower;
            this.flowers = new Flower[temp.length];
            for (int i = 0; i < flowers.length; i++) {
                this.flowers[i] = temp[i];
            }
        }
    }

    private void updateAccessoryList(Accessory accessory) {
        if (accessories.length == 0) {
            accessories = new Accessory[1];
            accessories[0] = accessory;
        } else {
            Accessory[] temp = new Accessory[accessories.length + 1];
            for (int i = 0; i < accessories.length; i++) {
                temp[i] = accessories[i];
            }
            temp[accessories.length] = accessory;
            this.accessories = new Accessory[temp.length];
            for (int i = 0; i < accessories.length; i++) {
                this.accessories[i] = temp[i];
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public Accessory[] getAttributes() {
        return accessories;
    }

    public void setAttributes(Accessory[] accessories) {
        this.accessories = accessories;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bouquet { " +
                "id = " + id +
                ", \nflowers = " + Arrays.toString(flowers) +
                ", \naccessories = " + Arrays.toString(accessories) +
                ", \ntotalPrice = " + totalPrice +
                '}';
    }

    private int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        return result;
    }


}
