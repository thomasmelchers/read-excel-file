package com.thomasmelchers.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ApplicationProperties {

    private static final String PROPERTIES_FILE = "application.properties";
    private static final Properties properties = new Properties();

    private static final Logger logger = LogManager.getLogger(ApplicationProperties.class);

    static {
        try (InputStream is = ApplicationProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(is);
        } catch (IOException e) {
            logger.error("Failed to load properties file", e);
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
