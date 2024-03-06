package com.thomasmelchers.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;



public class PostgresConnection {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(PostgresConnection.class.getName());
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
                LOGGER.severe("Connection to Postgres database failed");
            }
        } catch(SQLException e) {

            LOGGER.severe("Error " + e.getMessage());
        }

        return connection;
    }


}
