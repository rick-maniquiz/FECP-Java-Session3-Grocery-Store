package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;

public class Inventory {
    private HashMap<String, Integer> stocks = new HashMap<>();

    public boolean checkProduct(String productName, boolean verbose){
        if (this.stocks.containsKey(productName)){
            if (verbose) System.out.println("There are " + this.stocks.get(productName) + " units of " + productName + ".");
            return true;
        }
        if (verbose) System.out.println("There are no " + productName + " in the inventory.");
        return false;
    }

//    public void getStock(String productName){
//        if(this.checkProduct(productName)){
//            return this.stocks.get(productName);
//        }
//        return 0;
//    }

    public int addProduct(String productName, int amount){
        if(!this.checkProduct(productName, false) && amount > 0){
            this.stocks.put(productName, amount);
        } else if (!this.checkProduct(productName, false)) {
            System.out.println("Invalid amount!");
            return -1;
        } else {
            System.out.println(productName + " already exists!");
            return -2;
        }

        System.out.println(productName + " has been added!");
        return 0;
    }

    public int removeProduct(String productName){
        if(this.checkProduct(productName, false)){
            System.out.println(productName + " has been removed!");
            this.stocks.remove(productName);
        } else {
            System.out.println("No " + productName + " available in the inventory!");
        }

        return 0;
    }

    public int updateProduct(String productName, int amount){
        if(this.checkProduct(productName, false) && amount > 0){
            this.stocks.replace(productName, amount);
        } else if (this.checkProduct(productName, false) && amount <= 0) {
            System.out.println("Invalid amount!");
            return -1;
        } else if (!this.checkProduct(productName, false)){
            System.out.println(productName + "does not exist in the inventory!");
            return -2;
        }

        System.out.println(productName + " has been updated!");
        return 0;
    }

    public void viewInventory(){
        System.out.println("--- Items in stock ---");
        this.stocks.entrySet().stream().toList().forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue()));
        System.out.println("------- (END) --------");
    }

}
