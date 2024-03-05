package com.thomasmelchers.processor;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class FolderWatcher {

    private static final Logger LOGGER = LogManager.getLogger(FolderWatcher.class);
    final File directory ;


    public FolderWatcher(File directoryPath) {
        this.directory = directoryPath;
    }

    // Check if the directory exists and is a directory
    public boolean isDirectoryExists() {

        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: " + directory.getAbsolutePath());
        }
        return true;
    }


    public List<File> getListOfXlsFiles() {

        List<File> xlsFiles = new ArrayList<>();

        if (!isDirectoryExists()){
            return null;
        }

        File[] files = directory.listFiles();

        if(files == null) {
            return null;
        }

        for (File f : files) {
            if (f.getName().endsWith(".xls")) {
                xlsFiles.add(f);
            }
        }

       LOGGER.info("total of xls files: {}", xlsFiles.size());
        return xlsFiles;
    }


}
