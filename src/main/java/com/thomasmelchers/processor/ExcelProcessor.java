package com.thomasmelchers.processor;

import com.thomasmelchers.dao.Dao;
import com.thomasmelchers.utils.ApplicationProperties;
import com.thomasmelchers.utils.MovingFile;

import java.io.File;
import java.util.List;

public class ExcelProcessor {

    private List<File> excelFiles;
    private ExcelReader excelReader;


    public ExcelProcessor(List<File> excelFiles) {
        if (excelFiles == null) {
            throw new NullPointerException("The array is empty");
        }
        this.excelReader = new ExcelReader();
        this.excelFiles = excelFiles;
    }

    public void readingAllExcelFiles() {
        for (File xlsFile : excelFiles) {

            // store the filename
            String filename = xlsFile.getName();

            // Move the file to processing's folder
            MovingFile.moveFiles(filename, new File(ApplicationProperties.getDirectoryIncoming()), new File(ApplicationProperties.getDirectoryProcessing()));

            // Read the Excel file
            excelReader.readingExcelFile(new File(ApplicationProperties.getDirectoryProcessing() + File.separator + filename) );

            // Serialize the data
            DataSerializer dataSerializer = new DataSerializer(excelReader.getDataList());
            dataSerializer.serializing();

            // Store the data
            Dao dao = new Dao(filename, dataSerializer.getSales());
            dao.savedData();
        }
    }

    public void setExcelReader(ExcelReader excelReader) {

        this.excelReader = excelReader;
    }
}
