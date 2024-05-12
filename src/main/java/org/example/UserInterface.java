package org.example;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
        Dealership dealership = new Dealership(); // needs params for name, address, and phone loaded from file

        public UserInterface() { // removed parameters temporarily
            // will fix if issues arise while adding multiple dealerships (MDC)

        }


        public void init () {
           // DealershipFileManager myDealershipFileManager = new DealershipFileManager();
          //  this.dealership = myDealershipFileManager.getDealership();
        }
        public void display(){
            Scanner scanner = new Scanner(System.in);
            //need to ask user something?
            String userCommand = scanner.next();
            boolean exit = false;

            while(!exit){
                switch (userCommand){
                    case "1":
                       // Option1();
                        break;
                    case "2":
                       // Option2();
                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid command! Please try again.");
                }
            }
        }
        public void processGetByPriceRequest() {}
        public void processGetByMakeModelRequest() {}
        public void processGetByYearRequest() {}
        public void processGetByColorRequest() {}
        public void processGetByMileageRequest() {}
        public void processGetByVehicleTypeRequest() {}
        public void processGetAllVehiclesRequest() {}
        public void processAddVehicleRequest() {}
        public void processRemoveVehicleRequest() {}

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No matching vehicles were found.");
        } else {
            System.out.println("VIN|YEAR|MAKE|MODEL|TYPE|COLOR|MILEAGE|PRICE");
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d|%d|%s|%s|%s|%s|%d|%f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        NumberFormat.getCurrencyInstance().format(vehicle.getPrice()));
            }
        }
    }
    }

