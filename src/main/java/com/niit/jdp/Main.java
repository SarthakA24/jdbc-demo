package com.niit.jdp;

import com.niit.jdp.service.database.DatabaseService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        try {
            boolean isDatabaseConnected = databaseService.connect();
            System.out.println("isDatabaseConnected = " + isDatabaseConnected);
        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Error wile connecting to the database!");
            exception.printStackTrace();
        } finally {
            databaseService.printConnectionStatus();
        }
    }
}