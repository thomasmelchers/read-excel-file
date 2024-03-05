package com.thomasmelchers.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @Test
    public void testSaleConstructorAndGetters() {

        // Create a sale object
        Sale sale = new Sale("Green Tea", "China", "John Doe", 2.0, 10.0, 20.0);

        // Assert constructor and getters
        assertEquals("Green Tea", sale.getTeaName());
        assertEquals("China", sale.getTeaOrigin());
        assertEquals("John Doe", sale.getCustomer());
        assertEquals(2.0, sale.getQuantity());
        assertEquals(10.0, sale.getPrice());
        assertEquals(20.0, sale.getTotal());

    }

    @Test
    public void testSaleSetters() {


        Sale sale = new Sale();

        sale.setTeaName("Green Tea");
        sale.setTeaOrigin("China");
        sale.setCustomer("John Doe");
        sale.setQuantity(2.0);
        sale.setPrice(10.0);
        sale.setTotal(20.0);

        // Assert setters
        assertEquals("Green Tea", sale.getTeaName());
        assertEquals("China", sale.getTeaOrigin());
        assertEquals("John Doe", sale.getCustomer());
        assertEquals(2.0, sale.getQuantity());
        assertEquals(10.0, sale.getPrice());
        assertEquals(20.0, sale.getTotal());
    }
}