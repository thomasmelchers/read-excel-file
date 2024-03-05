package com.thomasmelchers.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SalesTest {

    @Mock
    Sale mockSale = mock(Sale.class);

 @Test
 public void test_listOfSalesExist_constructorTest () {

     Sales sales = new Sales();

     List<Sale> salesList = sales.getSalesList();

     // Verify the list is not null
     assertNotNull(salesList);

     // Verify the list is empty
     assertTrue(salesList.isEmpty());
 }

 @Test
    public void test_setSalesList_listIsAdded() {

     List<Sale> salesList = new ArrayList<>();
     salesList.add(mockSale);
     salesList.add(mockSale);

     Sales sales = new Sales();
     sales.setSalesList(salesList);

     assertEquals(2, sales.getSalesList().size());
 }

 @Test
    public void test_addSales() {
     Sales sales = new Sales();

     sales.addSales(mockSale);

     assertEquals(1, sales.getSalesList().size());
     assertEquals(mockSale, sales.getSalesList().get(0));
 }

}