package com.thomasmelchers.processor;

import java.util.ArrayList;
import java.util.List;

public class DataList {

    List<ExcelDataCollector> excelDataCollectorList;

    public DataList() {
        this.excelDataCollectorList = new ArrayList<>();
    }

    public void addExcelDataCollector(ExcelDataCollector edc) {
        excelDataCollectorList.add(edc);
    }

    public List<ExcelDataCollector> getExcelDataCollectorList() {
        return excelDataCollectorList;
    }

    public void setExcelDataCollectorList(List<ExcelDataCollector> excelDataCollectorList) {
        this.excelDataCollectorList = excelDataCollectorList;
    }

    @Override
    public String toString() {
        return "DataList{" +
                "excelDataCollectorList=" + excelDataCollectorList +
                '}';
    }
}
