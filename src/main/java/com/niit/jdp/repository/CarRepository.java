package com.niit.jdp.repository;

import com.niit.jdp.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    // Create a method to write the Car object in the database using INSERT SQL Query
    public boolean createCarInDatabase(Car car, Connection connection) throws SQLException {
        // 1. write the SQL query for inserting a car row into the car table
        String insertCarQuery = "INSERT INTO `carsales`.`car` (`name`, `model`, `cost_in_rupees`) VALUES" + " (?, ?, ?);";
        // 2. use the connection object to execute the query
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertCarQuery)) {
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setDouble(3, car.getCostInRupees());
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        // 3. return true if the query was executed successfully
        return numberOfRowsAffected > 0;
    }

    // Create a method to read all the data from the database
    public List<Car> getAllCars(Connection connection) {
        List<Car> carsList = new ArrayList<>();
        return carsList;
    }
}
