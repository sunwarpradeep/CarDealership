package org.example;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership = new Dealership("Test Dealership", "123 Main St", "555-1234"); // needs params for name, address, and phone loaded from file

    private static final Scanner scanner = new Scanner(System.in);

    public void init () {
      DealershipFileManager myDealershipFileManager = new DealershipFileManager();
      this.dealership = myDealershipFileManager.getDealership();

    }
    public void display(){
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
                99) Quit""");

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
                System.out.println("To find vehicles by color, please enter the color:");
                processGetByColorRequest();
                break;
            case "5":
                System.out.println("To find vehicles by mileage, please enter min and max mileage:");
                processGetByMileageRequest();
                break;
            case "6":
                System.out.println("To search vehicle by type, enter vehicle type:");
                processGetByVehicleTypeRequest();
                break;
            case "7":
                processGetAllVehiclesRequest();
                System.out.println("Here is a list of all vehicles:");
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

    public void processGetByPriceRequest() {
        System.out.println("To find vehicles by price, enter a minimum and maximum price (in digits, ex: 2000).");
        System.out.println("Enter minimum price:");
        double min = scanner.nextDouble();
        System.out.println("Enter maximum price:");
        double max = scanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.println("To find vehicles, please enter make and model (ex: Ford):");
        System.out.println("Enter the vehicle manufacturer's name:");
        String make = scanner.nextLine();
        System.out.println("Enter the vehicle model name:");
        String model = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest() {
        System.out.println("To find vehicles by year range, enter the earliest and latest year (in digits, ex: 2000):");
        System.out.println("Enter the earliest year:");
        int min = scanner.nextInt();
        System.out.println("Enter the latest year:");
        int max = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest() {
        System.out.println("To find vehicles by color, please enter the color (ex: red):");
        System.out.println("Enter the desired color:");
        String color = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {
        System.out.println("To find vehicles by mileage, please enter min and max mileage (in digits, ex: 2000):");
        System.out.println("Enter the minimum mileage:");
        int min = scanner.nextInt();
        System.out.println("Enter the maximum mileage:");
        int max = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("To search vehicle by type, enter vehicle type (ex: truck):");
        System.out.println("Enter the vehicle type:");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {
        System.out.println("Here is a list of all vehicles:");
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No matching vehicles were found.");
        } else {
            System.out.println("VIN|YEAR|MAKE|MODEL|TYPE|COLOR|MILEAGE|PRICE");
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d|%d|%s|%s|%s|%s|%d|%s\n",
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

