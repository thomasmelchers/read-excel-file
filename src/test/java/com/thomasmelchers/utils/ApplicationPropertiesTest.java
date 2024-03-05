package com.thomasmelchers.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationPropertiesTest {

    @Test
    public void testProperties() {

        assertEquals("C:\\Users\\thoma\\Documents\\Projects\\JavaProjects\\Learnings\\ReadingExcelFile\\teaShop\\incoming", ApplicationProperties.getDirectoryIncoming());
    }
}