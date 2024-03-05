package com.thomasmelchers.processor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExcelProcessorTest {

    private ExcelProcessor processor;
    private List<File> excelFilesList;

//    @Mock
//    private ExcelReader excelReaderMock;

    @Mock
    private File mockFile1;

    @Mock
    private File mockFile2;

    @BeforeEach
    public void setup() {

        excelFilesList = new ArrayList<>();
//        excelFilesList.add(mockFile1);
//        excelFilesList.add(mockFile2);
//        processor = new ExcelProcessor(excelFilesList);
//        processor.setExcelReader(excelReaderMock);
    }

    @Test
    void testReadingAllFiles_whenListExists() {

        // Arrange
        excelFilesList.add(mockFile1);
        excelFilesList.add(mockFile2);
        processor = new ExcelProcessor(excelFilesList);

        ExcelReader excelReaderMock = mock(ExcelReader.class);
        processor.setExcelReader(excelReaderMock);

        // Act
        // Call the method to be tested
        processor.readingAllExcelFiles();

        // Assert
        // Verify that readExcelFile() is called for each file in the list
        verify(excelReaderMock, times(excelFilesList.size())).readingExcelFile(any(File.class));

    }

    @Test
    void testReadingAllFiles_whenListIsNull() {

        excelFilesList = null;

        assertThrows(NullPointerException.class, () -> {
            new ExcelProcessor(excelFilesList);
        });
    }
}