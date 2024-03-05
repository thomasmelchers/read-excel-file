package com.thomasmelchers.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MovingFile {

    private static final Logger LOGGER = LogManager.getLogger(MovingFile.class);

    public static void moveFiles(String filename, File fromDirectoryPath, File toDirectoryPath) {

        File fileToMove = new File(fromDirectoryPath + File.separator + filename);

        try {
            boolean result = fileToMove.renameTo(new File(toDirectoryPath + File.separator + filename));

            if (result) {
                fileToMove.delete();
                LOGGER.info(" {} has moved to new directory {}", filename, toDirectoryPath);
            } else {
                LOGGER.error("Not possible to move the file to the new location!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
