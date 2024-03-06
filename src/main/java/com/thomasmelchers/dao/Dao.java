package com.thomasmelchers.dao;

import com.thomasmelchers.models.Sale;
import com.thomasmelchers.models.Sales;
import com.thomasmelchers.processor.FolderWatcher;
import com.thomasmelchers.utils.ApplicationProperties;
import com.thomasmelchers.utils.MovingFile;
import com.thomasmelchers.utils.PostgresConnection;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;


public class Dao {

    private String filename;
    private Sales sales;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(Dao.class.getName());


    public Dao(String filename, Sales sales) {
        this.filename = filename;
        this.sales = sales;
        this.connection = new PostgresConnection().connectionToDatabase();
    }


    public void savedData()  {

        String query = "INSERT INTO sales(tea_name, tea_origin, customer, quantity, price, total) VALUES(?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (Sale sale : sales.getSalesList()) {
                preparedStatement.setString(1, sale.getTeaName());
                preparedStatement.setString(2, sale.getTeaOrigin());
                preparedStatement.setString(3, sale.getCustomer());
                preparedStatement.setDouble(4, sale.getQuantity());
                preparedStatement.setDouble(5, sale.getPrice());
                preparedStatement.setDouble(6, sale.getTotal());

                preparedStatement.executeUpdate();
            }

            LOGGER.info(String.format("The %d rows have been inserted into the sales table", sales.getSalesList().size()));
            MovingFile.moveFiles(filename, new File(ApplicationProperties.getDirectoryProcessing()), new File(ApplicationProperties.getDirectoryCompleted()));
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        } finally {
            try {
                connection.close();
                LOGGER.info("Connection to postgres database is closed");
            } catch (SQLException e) {
                LOGGER.severe(e.getMessage());
            }
        }

    }


}
