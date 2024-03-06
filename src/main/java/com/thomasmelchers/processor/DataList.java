package com.thomasmelchers.processor;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DataList {

    private static final Logger LOGGER = Logger.getLogger(DataList.class.getName());
    private List<ExcelDataCollector> excelDataCollectorList;

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
