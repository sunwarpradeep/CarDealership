package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {
    private static final String INVENTORY_FILE = "src/main/resources/inventory.csv";
    //This method should load and read the inventory.csv
    public void getDealership(){
        ArrayList<Dealership> dealerships = new ArrayList<>();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE))){
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                //deserialize the first line to import the information into Dealership
                String[] title = line.split("\\|");
                String name = title[0];
                String address = title[1];
                String phone = title[2];
                Dealership dealership = new Dealership(name, address, phone);
                dealerships.add(dealership);

                //deserialize the rest of the line to import the information into Vehicle
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
        }
        catch(IOException ex){
            System.out.println("Sorry couldn't read the file.");
        }
    }

    //This method will overwrite the inventory.csv file with the current dealership information and inventory list
    public void saveDealership(){
        //for now no code
    }
}
