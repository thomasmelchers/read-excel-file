package com.thomasmelchers;

import com.thomasmelchers.processor.ExcelProcessor;
import com.thomasmelchers.processor.FolderWatcher;
import com.thomasmelchers.utils.ApplicationProperties;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FolderWatcher fw = new FolderWatcher(new File(ApplicationProperties.getDirectoryIncoming())) ;
        ExcelProcessor processor = new ExcelProcessor(fw.getListOfXlsFiles());
        processor.readingAllExcelFiles();
    }
}
