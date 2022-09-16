package com.niit.jdp.model;

import java.util.Objects;

public class Car {
    private int id;
    private String name;
    private String model;
    private double costInRupees;

    public Car(int id, String name, String model, double costInRupees) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.costInRupees = costInRupees;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCostInRupees() {
        return costInRupees;
    }

    public void setCostInRupees(double costInRupees) {
        this.costInRupees = costInRupees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getId() == car.getId() && Double.compare(car.getCostInRupees(), getCostInRupees()) == 0 && Objects.equals(getName(), car.getName()) && Objects.equals(getModel(), car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getModel(), getCostInRupees());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", costInRupees=" + costInRupees +
                '}';
    }
}
