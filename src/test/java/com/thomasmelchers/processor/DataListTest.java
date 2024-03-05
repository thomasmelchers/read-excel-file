package com.thomasmelchers.processor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class DataListTest {

    @Mock
    ExcelDataCollector mockEdc = mock(ExcelDataCollector.class);

    private DataList dataList;

    @BeforeEach
    public void setUp() {
        dataList = new DataList();
    }


    @Test
    public void test_listExistsAndEmpty_inConstructor() {
        List<ExcelDataCollector> list = dataList.getExcelDataCollectorList();

        assertNotNull(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void test_addExcelDataCollector(){
        dataList.addExcelDataCollector(mockEdc);
        dataList.addExcelDataCollector(mockEdc);

        assertEquals(2, dataList.getExcelDataCollectorList().size());
    }

    @Test
    public void test_setDataList() {
        List<ExcelDataCollector> list = new ArrayList<>();
        list.add(mockEdc);

        dataList.setExcelDataCollectorList(list);

        assertEquals(mockEdc, dataList.getExcelDataCollectorList().get(0));
    }
}