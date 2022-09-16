package com.niit.jdp.repository;

import com.niit.jdp.model.Car;

import java.sql.*;
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
    public List<Car> getAllCars(Connection connection) throws SQLException {
        List<Car> carsList = new ArrayList<>();
        // 1. create a SQL query to retrieve all the rows from the car table
        String selectAllCarsQuery = "SELECT * FROM `carsales`.`car`;";
        // 2. use the connection object to execute the query
        try (Statement readCarsStatement = connection.createStatement()) {
            ResultSet resultSet = readCarsStatement.executeQuery(selectAllCarsQuery);
            // 3. iterate over the result set and create a car object for each row
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                double costInRupees = resultSet.getDouble("cost_in_rupees");
                Car car = new Car(id, name, model, costInRupees);
                carsList.add(car);
            }
        }
        return carsList;
    }
}
