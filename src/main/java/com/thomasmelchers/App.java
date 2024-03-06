package com.thomasmelchers;

import com.thomasmelchers.dao.Dao;
import com.thomasmelchers.processor.ExcelProcessor;
import com.thomasmelchers.processor.FolderWatcher;
import com.thomasmelchers.utils.ApplicationProperties;

import java.io.File;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        FolderWatcher fw = new FolderWatcher(new File(ApplicationProperties.getDirectoryIncoming())) ;
        ExcelProcessor processor = new ExcelProcessor(fw.getListOfXlsFiles());
        processor.readingAllExcelFiles();
    }
}
