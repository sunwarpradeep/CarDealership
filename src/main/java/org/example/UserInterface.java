package org.example;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
        Dealership dealership = new Dealership("Test Dealership", "123 Main St", "555-1234"); // needs params for name, address, and phone loaded from file

        private static final Scanner scanner = new Scanner(System.in);

        public UserInterface() { // removed parameters temporarily
            // will fix if issues arise while adding multiple dealerships (MDC)
            System.out.println("""
                    Welcome to the car dealership!
                              Would you like to:
                              1) Find vehicles by price range
                              2) Find vehicles by make/model
                              3) Find vehicles by year range
                              4) Find vehicles by color
                              5) Find vehicles by mileage range
                              6) Find vehicles by type
                              7) List all vehicles
                              8) Add a vehicle
                              9) Remove a vehicle
                              99) Quit
                           """);

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "99":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect Input");

            }
        }


        public void init () {
           // DealershipFileManager myDealershipFileManager = new DealershipFileManager();
          //  this.dealership = myDealershipFileManager.getDealership();
        }
        public void display(){
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
            public void processGetByPriceRequest() {
                //displayVehicles(dealership.getVehiclesByPrice());
            }
            public void processGetByMakeModelRequest() {
                //displayVehicles(dealership.getVehiclesByMakeModel());
            }
            public void processGetByYearRequest() {
                //displayVehicles(dealership.getVehiclesByYear());
            }
            public void processGetByColorRequest() {
                //displayVehicles(dealership.getVehiclesByColor());
            }
            public void processGetByMileageRequest() {
                //displayVehicles(dealership.getVehiclesByMileage());
            }
            public void processGetByVehicleTypeRequest() {
                //displayVehicles(dealership.getVehiclesByType());
            }
            public void processGetAllVehiclesRequest() {
                displayVehicles(dealership.getAllVehicles());
            }
            public void processAddVehicleRequest() {

            }
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

    public static String getInput(String prompt, boolean allowEmpty) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (allowEmpty || !input.isEmpty()) {
            return input;
        }
        System.out.println("The input cannot be empty. Please enter a value.");
        return getInput(prompt, allowEmpty);
    }
    }

