package com.niit.jdp.service.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    // URL of the database
    private static final String URL = "jdbc:mysql://localhost:3306/CarSales";
    // Credentials for the user trying to connect to the database
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sarthak@24";
    // A private field to store the reference of the connection object
    private Connection databaseConnection;

    public DatabaseService() {
        this.databaseConnection = null;
    }

    // A method that can connect to the database
    public boolean connect() throws ClassNotFoundException, SQLException {
        // Step 1 - Load the JDBC Driver into the program memory
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Step 2 - Create a database connection object using DriverManager class
        databaseConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        // Step 3 - Check if the connection is successful
        return databaseConnection != null;
    }

    public void printConnectionStatus() {
        if (databaseConnection != null) {
            System.out.println("Connected to the database!");
        } else {
            System.err.println("Not connected to the database!");
        }
    }
}
