package com.thomasmelchers.processor;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ExcelFileHeaders {

    private static final Logger LOGGER = Logger.getLogger(ExcelFileHeaders.class.getName());

    private List<String> excelFileHeaders;

    public ExcelFileHeaders() {
        this.excelFileHeaders = new ArrayList<>();

        excelFileHeaders.add("teaName");
        excelFileHeaders.add("teaOrigin");
        excelFileHeaders.add("customer");
        excelFileHeaders.add("quantity");
        excelFileHeaders.add("price");
        excelFileHeaders.add("total");
    }

    public List<String> getExcelFileHeaders() {
        return excelFileHeaders;
    }

    public String getHeader(int index) {

        if(index > excelFileHeaders.size()) {
            throw new ArrayIndexOutOfBoundsException("This index nb is out of bounds");
        }

        return excelFileHeaders.get(index);
    }
}
