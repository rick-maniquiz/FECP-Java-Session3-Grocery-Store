package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inventory;
    HashMap<String, Integer> stocks;


    @BeforeEach
    void setup(){
        inventory = new Inventory();
        stocks = inventory.getStocks(); // Get the instance variable stocks of inventory
    }

    @Test
    void addProductWithValidQuantity(){
        System.out.println("--- addProductWithValidQuantity test output ---");
        inventory.addProduct("Banana", 30);
        assertTrue(stocks.containsKey("Banana"));
        assertEquals(stocks.get("Banana"), 30);
        System.out.println("------ (END) ------");

    }

    @Test
    void addProductWithInvalidQuantity(){
        System.out.println("--- addProductWithInvalidQuantity test output ---");
        inventory.addProduct("Banana", -1);
        assertFalse(stocks.containsKey("Banana"));
        assertEquals(stocks.size(), 0);
        System.out.println("------ (END) ------");
    }

    @Test
    void addProductWithZeroQuantity(){
        System.out.println("--- addProductWithZeroQuantity test output ---");
        inventory.addProduct("Mango", 0);
        assertTrue(stocks.containsKey("Mango"));
        assertEquals(stocks.get("Mango"), 0);
        System.out.println("------ (END) ------");
    }

    @Test
    void addProductThatAlreadyExists(){
        System.out.println("--- addProductThatAlreadyExists test output ---");
        inventory.addProduct("Milk", 10);
        assertEquals(stocks.get("Milk"), 10);
        inventory.addProduct("Milk", 50);
        assertEquals(stocks.get("Milk"), 50);
        System.out.println("------ (END) ------");
    }

    @Test
    void checkProductThatAlreadyExists(){
        System.out.println("--- checkProductThatAlreadyExists test output ---");
        inventory.addProduct("Milk", 20);
        assertTrue(inventory.checkProduct("Milk", true));
        assertEquals(stocks.get("Milk"), 20);
        System.out.println("------ (END) ------");
    }

    @Test
    void checkProductThatDoesNotExist(){
        System.out.println("--- checkProductThatDoesNotExist test output ---");
        assertFalse(inventory.checkProduct("IceCream", true));
        assertFalse(stocks.containsKey("IceCream"));
        System.out.println("------ (END) ------");
    }

    @Test
    void updateProductThatAlreadyExistsWithValidQuantity(){
        System.out.println("--- updateProductThatAlreadyExistsWithValidQuantity test output ---");
        inventory.addProduct("Bread", 20);
        assertTrue(stocks.containsKey("Bread"));
        inventory.updateProduct("Bread", 25);
        assertEquals(stocks.get("Bread"), 25);
        System.out.println("------ (END) ------");
    }

    @Test
    void updateProductThatAlreadyExistsWithInvalidQuantity(){
        System.out.println("--- updateProductThatAlreadyExistsWithInvalidQuantity test output ---");
        inventory.addProduct("Bread", 20);
        assertTrue(stocks.containsKey("Bread"));
        inventory.updateProduct("Bread", -1);
        assertEquals(stocks.get("Bread"), 20);
        System.out.println("------ (END) ------");
    }

    @Test
    void updateProductThatDoesNotExist(){
        System.out.println("--- updateProductThatDoesNotExist test output ---");
        // inventory.updateProduct() returns -2 when the product does not exist in the inventory
        int updateProductStatusCode = inventory.updateProduct("Cheese", 10);
        assertTrue(stocks.isEmpty());
        assertEquals(updateProductStatusCode, -2);
        System.out.println("------ (END) ------");
    }

    @Test
    void removeProductThatAlreadyExists(){
        System.out.println("--- removeProductThatAlreadyExists test output ---");
        inventory.addProduct("Bread", 20);
        assertTrue(stocks.containsKey("Bread"));
        inventory.removeProduct("Bread");
        assertFalse(stocks.containsKey("Bread"));
        System.out.println("------ (END) ------");
    }

    @Test
    void removeProductThatDoesNotExist(){
        System.out.println("--- removeProductThatDoesNotExist test output ---");
        inventory.addProduct("Bread", 20);
        // inventory.removeProduct() returns -1 when the product does not exist in the inventory
        int updateRemoveStatusCode = inventory.removeProduct("Cheese");
        assertFalse(stocks.isEmpty());
        assertEquals(updateRemoveStatusCode, -1);
        System.out.println("------ (END) ------");
    }
}