package com.niit.jdp;

import com.niit.jdp.model.Car;
import com.niit.jdp.repository.CarRepository;
import com.niit.jdp.service.database.DatabaseService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        try {
            boolean isDatabaseConnected = databaseService.connect();
            System.out.println("isDatabaseConnected = " + isDatabaseConnected);
            if (databaseService.getDatabaseConnection() != null) {
                // prompt the user to input the car details to be added in the database
                Scanner scanner = new Scanner(System.in);
                System.out.println("Hello, please enter the details of your car");
                System.out.println("Please enter the name of the car");
                String name = scanner.nextLine();
                System.out.println("Please enter the model of the car");
                String model = scanner.nextLine();
                System.out.println("Please enter the cost of the car");
                double cost = scanner.nextDouble();
                Car car = new Car(0, name, model, cost);
                CarRepository carRepository = new CarRepository();
                boolean result = carRepository.createCarInDatabase(car, databaseService.getDatabaseConnection());
                if (result) {
                    System.out.println("Car created successfully");
                } else {
                    System.out.println("Car creation failed");
                }
            } else {
                System.err.println("Not connected to the database");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}