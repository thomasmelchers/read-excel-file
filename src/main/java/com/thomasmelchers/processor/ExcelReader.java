package com.thomasmelchers.processor;


import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;


public class ExcelReader {

    private ExcelFileHeaders excelFileHeaders;
    private DataList dataList;


    public ExcelReader() {
        this.excelFileHeaders = new ExcelFileHeaders();
        this.dataList = new DataList();
    }

    public void readingExcelFile(File excelFile) {
        if (excelFile == null) {
            throw new IllegalStateException("Excel file is not initialized");
        }

        try (FileInputStream fis = new FileInputStream(excelFile);
             Workbook workbook = WorkbookFactory.create(fis);) {

            Sheet sheet = workbook.getSheetAt(0);

            List<String> fileHeadersList = excelFileHeaders.getExcelFileHeaders();

            boolean firstRowSkipped = false;

            for (Row row : sheet) {

                ExcelDataCollector excelDataCollector = new ExcelDataCollector();

                if (!firstRowSkipped) {
                    firstRowSkipped = true;
                    continue;
                }

                int cellNb = 0;

                for (String header : fileHeadersList) {
                    Cell cell = row.getCell(cellNb);
                    String value = "";
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                value = String.valueOf(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                value = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case FORMULA:
                                if (cell.getCachedFormulaResultType() == NUMERIC) {
                                    value = String.valueOf(cell.getNumericCellValue());
                                    break;
                                }
                                break;
                            case BLANK:
                                value = "blank";
                                break;
                            default:
                                value = cell.getStringCellValue();
                        }

                        excelDataCollector.addKeyValuePairData(header, value);
                        cellNb++;
                    }
                }

                // add eachDataCollector to list
                dataList.addExcelDataCollector(excelDataCollector);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ExcelFileHeaders getExcelFileHeaders() {
        return excelFileHeaders;
    }

    public void setExcelFileHeaders(ExcelFileHeaders excelFileHeaders) {
        this.excelFileHeaders = excelFileHeaders;
    }

    public DataList getDataList() {
        return dataList;
    }

    public void setDataList(DataList dataList) {
        this.dataList = dataList;
    }
}
