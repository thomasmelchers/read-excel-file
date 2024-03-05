package com.thomasmelchers.processor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExcelFileHeadersTest {

    private ExcelFileHeaders excelFileHeaders;

    @BeforeEach
    public void setUp() {
        excelFileHeaders = new ExcelFileHeaders();
    }

    @Test
    public void testExcelFileHeaders_constructorAndGetter() {

        List<String> fileHeadersList = excelFileHeaders.getExcelFileHeaders();

        assertEquals(6,fileHeadersList.size() );
    }


    @ParameterizedTest
    @MethodSource
    public void testExcelFileHeaders_getElement(String expectedValue, int value) {

        assertEquals(expectedValue, excelFileHeaders.getHeader(value));
    }

    private static Stream<Arguments> testExcelFileHeaders_getElement() {
        return Stream.of(
                Arguments.of("teaName", 0),
                Arguments.of("teaOrigin", 1),
                Arguments.of("customer", 2),
                Arguments.of("quantity", 3),
                Arguments.of("price", 4),
                Arguments.of("total", 5)
        );
    }

    @Test
    public void testExcelFileHeaders_indexOutOfBounds() {
        int index = excelFileHeaders.getExcelFileHeaders().size() + 1 ;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            excelFileHeaders.getHeader(index);
        });
    }
}