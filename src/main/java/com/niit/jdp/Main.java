package com.niit.jdp;

import com.niit.jdp.service.database.DatabaseService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        try {
            boolean isDatabaseConnected = databaseService.connect();
            System.out.println("isDatabaseConnected = " + isDatabaseConnected);
            // prompt the user to input the car details to be added in the database
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hello, please enter the details of your car");
            System.out.println("Please enter the name of the car");
            String name = scanner.nextLine();
            System.out.println("Please enter the model of the car");
            String model = scanner.nextLine();
            System.out.println("Please enter the cost of the car");
            double cost = scanner.nextDouble();

        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Error wile connecting to the database!");
            exception.printStackTrace();
        } finally {
            databaseService.printConnectionStatus();
        }
    }
}