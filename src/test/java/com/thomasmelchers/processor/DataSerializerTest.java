package com.thomasmelchers.processor;

import com.thomasmelchers.models.Sale;
import com.thomasmelchers.models.Sales;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DataSerializerTest {


    private DataSerializer dataSerializer;

    @Mock
    DataList mockDataList;

    @Mock
    Sales mockSales = mock(Sales.class);

    @Mock
    Sale mockSale;

    @BeforeEach
    public void setUp() {

        // Creating mocks
        mockDataList = mock(DataList.class);
        ExcelDataCollector mockExcelDataCollector = mock(ExcelDataCollector.class);

        // Creation of dataCollector => one row of the Excel sheet
        Map<String, String> dataCollectorMap = new LinkedHashMap<>();
        dataCollectorMap.put("teaName", "Green Tea");
        dataCollectorMap.put("teaOrigin", "China");
        dataCollectorMap.put("customer", "customer 1");
        dataCollectorMap.put("quantity", "50.0");
        dataCollectorMap.put("price", "25.0");
        dataCollectorMap.put("total", "1250.0");

        // adding the data to ExcelDataCollector mock
        when(mockExcelDataCollector.getDataCollector()).thenReturn(dataCollectorMap);

        // Adding the ExcelDataCollector mock to the list of ExcelDataCollector (multiple rows)
        List<ExcelDataCollector> mockExcelDataCollectorList = new ArrayList<>();
        mockExcelDataCollectorList.add(mockExcelDataCollector);
        when(mockDataList.getExcelDataCollectorList()).thenReturn(mockExcelDataCollectorList);

        // Creating the class with the mock
        this.dataSerializer = new DataSerializer(mockDataList);

        // Creation of Sale's mock
        this.mockSale = mock(Sale.class);
        when(mockSale.getTeaName()).thenReturn("Green Tea");
        when(mockSale.getTeaOrigin()).thenReturn("China");
        when(mockSale.getCustomer()).thenReturn("customer 1");
        when(mockSale.getQuantity()).thenReturn(50.0);
        when(mockSale.getPrice()).thenReturn(25.0);
        when(mockSale.getTotal()).thenReturn(1250.0);
    }


    @Test
    void test_serializing() {

        dataSerializer.serializing();

        Sales sales = dataSerializer.getSales();

        assertEquals(1, sales.getSalesList().size());
        assertEquals(mockSale.getTeaName(), sales.getSalesList().get(0).getTeaName());
        assertEquals(mockSale.getTeaOrigin(), sales.getSalesList().get(0).getTeaOrigin());
        assertEquals(mockSale.getCustomer(), sales.getSalesList().get(0).getCustomer());
        assertEquals(mockSale.getQuantity(), sales.getSalesList().get(0).getQuantity());
        assertEquals(mockSale.getPrice(), sales.getSalesList().get(0).getPrice());
        assertEquals(mockSale.getTotal(), sales.getSalesList().get(0).getTotal());

    }

}