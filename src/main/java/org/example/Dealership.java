package org.example;

import java.util.ArrayList;
import java.util.Vector;

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

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void getVehiclesByPrice(double min, double max) {
    }

    public void getVehiclesByMakeModel(String make, String model) {}

    public void getVehiclesByYear(double min, double max) {}

    public void getVehiclesByColor(String color) {}

    public void getVehiclesByMileage(double min, double max) {}

    public void getVehiclesByType(String vehicleType) {}

    public void getAllVehicles() {}

    public void addVehicle(ArrayList <Vehicle> vehicle) {}

    public void removeVehicle(ArrayList <Vehicle> vehicle) {}
}
