package com.niit.jdp.service.database;

import java.sql.Connection;

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
    public boolean connect() throws ClassNotFoundException {
        // Step 1 - Load the JDBC Driver into the program memory
        Class.forName("com.mysql.cj.jdbc.Driver");
        return false;
    }
}
