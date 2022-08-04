package com.company.service;

import com.company.exception.MyException;
import com.company.model.Bouquet;
import com.company.model.Flower;

import java.util.Scanner;

public class ShopService {

    private Bouquet[] bouquets;
    private int id = 0;

    public ShopService() {
        this.bouquets = new Bouquet[0];
    }

    private void addBouquet(Bouquet bouquet) {
        if (bouquets.length == 0) {
            bouquets = new Bouquet[1];
            bouquets[0] = bouquet;
        } else {
            Bouquet[] temp = new Bouquet[bouquets.length + 1];
            for (int i = 0; i < bouquets.length; i++) {
                temp[i] = bouquets[i];
            }
            temp[bouquets.length] = bouquet;
            bouquets = new Bouquet[temp.length];
            for (int i = 0; i < bouquets.length; i++) {
                bouquets[i] = temp[i];
            }
        }
    }

    private void editBouquet(int id, Bouquet bouquet) {
        for (int i = 0; i < bouquets.length; i++) {
            if (bouquets[i].getId() == id) {
                bouquets[i] = bouquet;
            }
        }
    }

    private void deleteBouquet(int id) {
        int currentNumber = 0;
        for (int i = 0; i < bouquets.length; i++) {
            if (bouquets[i].getId() == id) {
                Bouquet[] newTemp = new Bouquet[bouquets.length - 1];
                for (int j = 0; j < bouquets.length; j++) {
                    if (j == i) {
                        continue;
                    } else {
                        newTemp[currentNumber] = bouquets[j];
                        currentNumber++;
                    }
                }
                bouquets = new Bouquet[newTemp.length];
                for (int j = 0; j < bouquets.length; j++) {
                    bouquets[j] = newTemp[j];
                }
            }
        }
    }

    public void start() {
        int choice = 0;

        do {
            System.out.println("\n1.Create bouquet;;");
            System.out.println("2.Bouquet operations;");
            System.out.println("3.Print info about bouquets in shop");
            System.out.println("0.Exit");
            System.out.print("Enter -> ");

            choice = getInputInt();

            switch (choice) {
                case 1:
                    createBouquet();
                    break;
                case 2:
                    bouquetOperations();
                    break;
                case 3:
                    System.out.println("\nBouquets in shop:");
                    if (bouquets.length > 0) {
                        printBouquets();
                    } else {
                        System.out.println("\nThere are no bouquets to show...");
                    }
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
        return;
    }

    private void createBouquet() {
        Bouquet bouquet = new Bouquet(++id);
        int choice = 0;
        do {
            System.out.println("\n1.Add flower;");
            System.out.println("2.Add accessory;");
            System.out.println("3.Print current bouquet details;");
            System.out.println("4.Create bouquet and back;");
            System.out.println("0.Back;");
            System.out.print("Enter -> ");

            choice = getInputInt();

            switch (choice) {
                case 1:
                    System.out.print("\nChose flower type: 1. Rose, 2. Peonies, 3. Lily -> ");
                    int type = getInputInt();
                    System.out.print("\nEnter amount of flowers -> ");
                    int amount = getInputInt();
                    System.out.print("\nChose freshness (from 1 to 5 days after cutting) -> ");
                    int freshnessLevel = getInputInt();
                    System.out.print("\nChose stem length (from 1 to 3 sm) -> ");
                    int stemLength = getInputInt();
                    System.out.print("\nEnter flower color -> ");
                    String color = getInputString();

                    bouquet.addFlower(type, amount, color, freshnessLevel, stemLength);
                    break;

                case 2:
                    System.out.println("Chose accessory type: 1.Bijouterie; 2.Card, 3.Baloons, 4.Candies; -> ");
                    int typeAccessory = getInputInt();
                    bouquet.addAccessory(typeAccessory);
                    break;

                case 3:
                    bouquet.calculateTotalPrice();
                    System.out.println(bouquet);
                    break;
                case 4:
                    bouquet.calculateTotalPrice();
                    addBouquet(bouquet);
                    break;
                case 0:
                    break;
            }

        } while (choice != 0 && choice != 4);
    }

    private void bouquetOperations() {
        int choice = 0;

        do {
            System.out.println("\n1.Sort flowers in bouquet by freshness level;");
            System.out.println("2.Find flower in bouquet by length of stem;");
            System.out.println("3.Edit bouquet by id;");
            System.out.println("4.Delete bouquet by id;");
            System.out.println("0.Back;");
            System.out.print("Enter -> ");

            choice = getInputInt();

            switch (choice) {
                case 1:
                    sortByFreshnessLevel();
                    break;
                case 2:
                    System.out.print("\nEnter bouquet id to find flowers -> ");
                    int idToFind = getInputInt();
                    System.out.print("\nEnter stem length -> ");
                    int stemLength = getInputInt();
                    System.out.println("\nWe have found these flowers: ");
                    try {
                        findByStemLength(idToFind, stemLength);
                    } catch (MyException e) {
                        System.out.println("Error " + e);
                    }

                    break;
                case 3:
                    System.out.print("\nEnter bouquet id to edit -> ");
                    int id = getInputInt();
                    editBouquetById(id);
                    break;
                case 4:
                    System.out.print("\nEnter bouquet id to delete -> ");
                    int idToDelete = getInputInt();
                    deleteBouquet(idToDelete);
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private void sortByFreshnessLevel() {
        Flower[] sortedFlowers;
        int currentNumber = 0;
        System.out.print("\nEnter id of bouquet to sort -> ");
        int chose = getInputInt();
        for (int i = 0; i < bouquets.length; i++) {
            if (bouquets[i].getId() == chose) {
                sortedFlowers = new Flower[bouquets[i].getFlowers().length];
                sortedFlowers[0] = bouquets[i].getFlowers()[0];
                for (int j = 0; j < bouquets[i].getFlowers().length; j++) {
                    if (sortedFlowers[0].getFreshnessLevel() <= bouquets[i].getFlowers()[j].getFreshnessLevel()) {
                        sortedFlowers[0] = bouquets[i].getFlowers()[j];
                    }
                }
                for (int j = 0; j < sortedFlowers.length; j++) {
                    sortedFlowers[j] = sortedFlowers[0];
                }
                for (int j = 0; j < bouquets[i].getFlowers().length; j++) {
                    for (int k = 0; k < bouquets[i].getFlowers().length; k++) {
                        if (bouquets[i].getFlowers()[k] != null) {
                            if (sortedFlowers[j].getFreshnessLevel() >= bouquets[i].getFlowers()[k].getFreshnessLevel()) {
                                sortedFlowers[j] = bouquets[i].getFlowers()[k];
                                currentNumber = k;
                            }
                        }
                    }
                    bouquets[i].getFlowers()[currentNumber] = null;
                }
                bouquets[i].setFlowers(sortedFlowers);
            }
        }
    }

    private void findByStemLength(int id, int stemLength) throws MyException {
        if (stemLength < 1) {
            throw new MyException(stemLength, "Stem length < 1!!!");
        }
        int counter = 0;
        for (int i = 0; i < bouquets.length; i++) {
            if (bouquets[i].getId() == id) {
                for (int j = 0; j < bouquets[i].getFlowers().length; j++) {
                    if (bouquets[i].getFlowers()[j].getStemLength() == stemLength) {
                        System.out.println(++counter + ". " + bouquets[i].getFlowers()[j].toString());
                    }
                }
            }
        }
    }

    private void editBouquetById(int id) {
        Bouquet bouquet = new Bouquet(id);
        int choice = 0;
        do {
            System.out.println("\n1.Add flower;");
            System.out.println("2.Add accessory;");
            System.out.println("3.Print current bouquet details;");
            System.out.println("4.Create bouquet and edit;");
            System.out.println("0.Back to main menu;");
            System.out.print("Enter -> ");

            choice = getInputInt();

            switch (choice) {
                case 1:
                    System.out.print("\nChose flower type: 1. Rose, 2. Peonies, 3. Lily -> ");
                    int type = getInputInt();
                    System.out.print("\nEnter amount of flowers -> ");
                    int amount = getInputInt();
                    System.out.print("\nChose freshness (from 1 to 5 days after cutting) -> ");
                    int freshnessLevel = getInputInt();
                    System.out.print("\nChose stem length (from 1 to 3 sm) -> ");
                    int stemLength = getInputInt();
                    System.out.print("\nEnter flower color -> ");
                    String color = getInputString();

                    bouquet.addFlower(type, amount, color, freshnessLevel, stemLength);
                    break;

                case 2:
                    System.out.println("Chose accessory type: 1.Bijouterie; 2.Card, 3.Baloons, 4.Candies; -> ");
                    int typeAccessory = getInputInt();
                    bouquet.addAccessory(typeAccessory);
                    break;

                case 3:
                    bouquet.calculateTotalPrice();
                    System.out.println(bouquet);
                    break;
                case 4:
                    bouquet.calculateTotalPrice();
                    editBouquet(id, bouquet);
                    break;
                case 0:
                    break;
            }

        } while (choice != 0 && choice != 4);
    }

    private void printBouquets() {
        for (int i = 0; i < bouquets.length; i++) {
            System.out.println((i + 1) + ". " + bouquets[i].toString());
        }
    }

    private int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        return result;
    }

    private String getInputString() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }
}
