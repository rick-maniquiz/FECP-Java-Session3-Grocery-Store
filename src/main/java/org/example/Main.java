package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        String productName;
        int amount;
        int option = 0;

        while (option != 6){
            System.out.println("---- Grocery Inventory Menu ----");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Enter Option: ");
            option = scanner.nextInt();
            switch (option){
                case 1:{
                    inventory.viewInventory();
                    break;
                }
                case 2:{
                    System.out.print("Enter product name: ");
                    productName = scanner.next();
                    System.out.print("Enter amount: ");
                    amount = scanner.nextInt();
                    while (inventory.addProduct(productName, amount) == -1){
                        System.out.print("Enter amount: ");
                        amount = scanner.nextInt();
                    }
                    break;
                }
                case 3:{
                    System.out.print("Enter product name: ");
                    productName = scanner.next();
                    inventory.checkProduct(productName, true);
                    break;
                }
                case 4:{
                    System.out.print("Enter name of product to update: ");
                    productName = scanner.next();
                    if (!inventory.checkProduct(productName, true)){
                        break;
                    }
                    System.out.print("Enter new amount: ");
                    amount = scanner.nextInt();
                    while (inventory.updateProduct(productName, amount) == -1){
                        System.out.print("Enter valid amount: ");
                        amount = scanner.nextInt();
                    }
                    break;
                }
                case 5:{
                    System.out.print("Enter name of product to remove: ");
                    productName = scanner.next();
                    inventory.removeProduct(productName);
                    break;
                }
                default:{
                    if (option != 6) System.out.println("Invalid Option!");
                    break;
                }
            }
        }
    }
}