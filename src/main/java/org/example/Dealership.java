package org.example;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList <Vehicle> vehicle;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void getVehiclesByPrice(double min, double max) {
    }

    public void getVehiclesByMakeModel(String make, String model) {}

    public void getVehiclesByYear(double min, double max) {}

    public void getVehiclesByColor(String color) {}

    public void getVehiclesByMileage(double min, double max) {}

    public void getVehiclesByType(String vehicleType) {}

    public void getAllVehicles() {}

    public void addVehicle(vehicle) {}

    public void removeVehicle(vehicle) {}
}
