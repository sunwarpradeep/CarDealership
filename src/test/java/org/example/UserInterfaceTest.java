package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class UserInterfaceTest {
  @Test
    void unittest(){
      Dealership dealership = new Dealership("Test Dealership", "123 Main St", "555-1234");
      ArrayList<Vehicle> vehicles = new ArrayList<>();
      vehicles.add(new Vehicle(1234, 2022, "Toyota", "Camry", "Sedan", "Red", 10045, 25000.0));
      vehicles.add(new Vehicle(5678, 2021, "Honda", "Civic", "Sedan", "Blue", 32150, 22000.0));
      vehicles.add(new Vehicle(9012, 2020, "Ford", "F150", "Truck", "White", 80142, 30000.0));
      dealership.setVehicle(vehicles);
      List<Vehicle> result = dealership.getAllVehicles();
      assertEquals(3,result.size());
  }

}