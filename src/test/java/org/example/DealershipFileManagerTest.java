package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealershipFileManagerTest {
    @Test
    void tester() throws FileNotFoundException {
        final String INVENTORY_FILE = "src/main/resources/inventory.csv";
        Boolean result = null;
        Dealership dealership = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE))) {

            //deserialize the first line to import the information into Dealership
            String line = reader.readLine();//only deserialize the first line
            String[] title = line.split("\\|");
            String name = title[0];
            String address = title[1];
            String phone = title[2];
            dealership = new Dealership(name, address, phone);

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            //deserialize the rest of the line to import the information into Vehicle
            while((line = reader.readLine()) != null){
                String[] data = line.split("\\|");
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle  = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);

            }

            dealership.setVehicle(vehicles);

            result = true;

        } catch (IOException ex) {
            result = false;
            System.out.println("Sorry couldn't read the file.");
        }

        assertTrue(result);

    }
}