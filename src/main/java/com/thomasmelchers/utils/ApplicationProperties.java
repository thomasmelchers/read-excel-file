package com.thomasmelchers.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;


public class ApplicationProperties {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(ApplicationProperties.class.getName());
    private static final String PROPERTIES_FILE = "application.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream is = ApplicationProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(is);
        } catch (IOException e) {
            LOGGER.severe("Failed to load properties file");
        }
    }

    public static String getDirectoryIncoming() {
        return properties.getProperty("directory.incoming");
    }
    public static String getDirectoryProcessing() {
        return properties.getProperty("directory.processing");
    }

    public static String getDirectoryCompleted() {
        return properties.getProperty("directory.completed");
    }

    public static String getPostgresDatabase() {
        return properties.getProperty("postgres.database");
    }

    public static String getPostgresUsername() {
        return properties.getProperty("postgres.username");
    }

    public static String getPostgresPassword() {
        return properties.getProperty("postgres.password");
    }
}
