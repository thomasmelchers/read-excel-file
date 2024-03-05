package com.thomasmelchers.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostgresConnection {

    private static final Logger LOGGER = LogManager.getLogger(PostgresConnection.class);
    final String DATABASE ;
    final String USER;
    final String PASSWORD;

    public PostgresConnection() {
        this.DATABASE = ApplicationProperties.getPostgresDatabase();
        this.USER = ApplicationProperties.getPostgresUsername();
        this.PASSWORD = ApplicationProperties.getPostgresPassword();
    }

    public Connection connectionToDatabase () {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + DATABASE, USER, PASSWORD);

            if(connection != null) {
               LOGGER.info("Connected to Postgres database");
            } else {
                LOGGER.error("Connection to Postgres database failed");
            }
        } catch(SQLException e) {

            LOGGER.error("Error " + e.getMessage());
        }

        return connection;
    }


}
