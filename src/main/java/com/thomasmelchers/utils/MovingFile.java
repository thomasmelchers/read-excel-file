package com.thomasmelchers.utils;

import java.io.File;
import java.util.logging.Logger;

public class MovingFile {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(MovingFile.class.getName());

    public static void moveFiles(String filename, File fromDirectoryPath, File toDirectoryPath) {

        File fileToMove = new File(fromDirectoryPath + File.separator + filename);

        try {
            boolean result = fileToMove.renameTo(new File(toDirectoryPath + File.separator + filename));

            if (result) {
                fileToMove.delete();
                LOGGER.info(String.format(" %s has moved to new directory %s", filename, toDirectoryPath));
            } else {
                LOGGER.severe("Not possible to move the file to the new location!");
            }
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }

    }
}
