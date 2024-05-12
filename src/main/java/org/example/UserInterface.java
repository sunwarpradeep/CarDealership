package org.example;

import java.util.Scanner;

public class UserInterface {
        Dealership dealership = new Dealership();

        public UserInterface(Dealership dealership) {

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
    }

