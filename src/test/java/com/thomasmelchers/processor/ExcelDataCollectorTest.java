package com.thomasmelchers.processor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ExcelDataCollectorTest {

   private ExcelDataCollector excelDataCollector;

    @BeforeEach
    public void setup() {
        excelDataCollector = new ExcelDataCollector();
    }

    @Test
    public void testGetAndSetDataCollector() {
        // Arrange
        Map<String, String> testMap = new LinkedHashMap<>();
        testMap.put("key", "value");
        excelDataCollector.setDataCollector(testMap);

        assertEquals(testMap, excelDataCollector.getDataCollector());

    }

    @Test
    public void testAddData() {
        Map<String, String> testMap = new LinkedHashMap<>();
        testMap.put("teaName", "Green Tea");
        testMap.put("teaOrigin", "China");

        excelDataCollector.setDataCollector(testMap);

        String key = "customer";
        String value = "Naos";

        excelDataCollector.addKeyValuePairData(key, value);

        assertEquals(value, excelDataCollector.getDataCollector().get(key));


    }



}