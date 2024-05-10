package org.example;

    public class UserInterface {
        Dealership dealership = new Dealership();

        public UserInterface(Dealership dealership) {
            this.dealership = dealership;

        }

        public void display(){}
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

