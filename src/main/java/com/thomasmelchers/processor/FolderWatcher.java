package com.thomasmelchers.processor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class FolderWatcher {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(FolderWatcher.class.getName());
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

        int nbFiles = xlsFiles.isEmpty() ? 0 : xlsFiles.size();
        LOGGER.info("Total of xls files present in incoming's folder: " + nbFiles);
        return xlsFiles;
    }


}
