package com.thomasmelchers.processor;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FolderWatcherTest {

    @InjectMocks
    private FolderWatcher folderWatcher;

    @Mock
    private File directoryMock;


    @BeforeEach
    void setUp() {
        folderWatcher = new FolderWatcher(directoryMock);
    }

    @Test
    void testIsDirectoryExist_whenDirectoryExists() {
        when(directoryMock.exists()).thenReturn(true);
        when(directoryMock.isDirectory()).thenReturn(true);

        assertTrue(folderWatcher.isDirectoryExists());

        verify(directoryMock).exists();
        verify(directoryMock).isDirectory();
    }

    @Test
    void testIsDirectoryExists_whenDirectoryDoesNotExist() {

        when(directoryMock.exists()).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> {
            folderWatcher.isDirectoryExists();
        });


        verify(directoryMock).exists();
    }

    @Test
    void testIsDirectoryExists_whenNotADirectory() {
        when(directoryMock.exists()).thenReturn(true);
        when(directoryMock.isDirectory()).thenReturn(false);

        assertThrows(IllegalArgumentException.class,() -> {
            folderWatcher.isDirectoryExists();
        });

        verify(directoryMock).exists();
        verify(directoryMock).isDirectory();
    }

    @Test
    void testGetListOfXlsFiles_whenDirectoryDoesNotExist(){
        when(directoryMock.exists()).thenReturn(true);
        when(directoryMock.isDirectory()).thenReturn(false);

        assertThrows(IllegalArgumentException.class,() -> {
            folderWatcher.isDirectoryExists();
        });

        verify(directoryMock).exists();
        verify(directoryMock).isDirectory();
    }

    @Test
    void testGetListOfXlsFiles_whenDirectoryIsEmpty(){
        when(directoryMock.exists()).thenReturn(true);
        when(directoryMock.isDirectory()).thenReturn(true);

        when(directoryMock.listFiles()).thenReturn(new File[]{});

        List<File> results = folderWatcher.getListOfXlsFiles();

        assertEquals(0, results.size());
    }

    @Test
    void testGetListOfXlsFiles_whenDirectoryHasXlsFiles(){
        when(directoryMock.exists()).thenReturn(true);
        when(directoryMock.isDirectory()).thenReturn(true);



        File file1 = new File("C:\\Users\\thoma\\Documents\\Projects\\JavaProjects\\Learnings\\ReadingExcelFile\\teaShop\\incoming\\file1.xls");
        File file2 = new File("C:\\Users\\thoma\\Documents\\Projects\\JavaProjects\\Learnings\\ReadingExcelFile\\teaShop\\incoming\\file2.xls");
        File file3 = new File("C:\\Users\\thoma\\Documents\\Projects\\JavaProjects\\Learnings\\ReadingExcelFile\\teaShop\\incoming\\file3.xlsx");
        when(directoryMock.listFiles()).thenReturn(new File[]{file1, file2, file3});


        List<File> results = folderWatcher.getListOfXlsFiles();

        assertEquals(2, results.size());
        assertEquals(file1, results.get(0));
        assertEquals(file2, results.get(1));
    }

}