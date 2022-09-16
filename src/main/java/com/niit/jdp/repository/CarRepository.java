package com.niit.jdp.repository;

import com.niit.jdp.model.Car;

import java.sql.Connection;

public class CarRepository {

    // Create a method to write the Car object in the database using INSERT SQL Query
    public boolean createCarInDatabase(Car car, Connection connection) {
        // 1. write the SQL query for inserting a car row into the car table
        String insertCarQuery = "INSERT INTO `carsales`.`car` (`name`, `model`, `cost_in_rupees`) VALUES" + " (?, ?, ?);";
        return false;
    }
}
