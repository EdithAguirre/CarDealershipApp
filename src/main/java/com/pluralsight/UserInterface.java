/*
UserInterface will be responsible for all output to the screen, reading of user input,
and "dispatching" of the commands to the Dealership as needed. (ex: when the user selects
"List all Vehicles", UserInterface would call the appropriate Dealership method and then
display the vehicles it returns.)
 */

package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    // Dealership object
    Dealership dealership;

    // Parameterless constructor
    public UserInterface() {
    }

    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }
    public void display() {
        // call init method
        init();


        while(true) {

            // Display the menu
            System.out.print("""
                    🚗 Welcome to the Car Dealership App! 🚗
                    -----------------------------------------
                    Select an option to continue.
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type (car, truck, SUV, van)
                    7 - List ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit
                    
                    ------------------------------------------
                    Enter your option: \
                    """);

            // Read user command
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumes the new line character

            // Switch statement that calls the correct process() method to display menu
            switch (option){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("Thank you, come back soon!");
                    System.out.println("\uD80C\uDD9D \uD80C\uDD9F \uD80C\uDD9E \uD80C\uDD9D 🐈‍");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please enter a valid choice (1,2,3,4,5,6,7,8,9, or 99).");
                    break;
            }
        }
    }

    // Methods
    public void processGetByPriceRequest(){
        System.out.print("Enter the minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter the maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> vehicleList = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicleList);
    }
    public void processGetByMakeModelRequest(){
        System.out.print("Enter the make: ");
        String make = scanner.nextLine().trim();
        System.out.print("Enter the model: ");
        String model = scanner.nextLine().trim();

        List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicleList);
    }

    public void processGetByYearRequest(){
        System.out.print("Enter minimum year: ");
        int yearMin = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int yearMax = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicleList = dealership.getVehiclesByYear(yearMin, yearMax);
        displayVehicles(vehicleList);
    }
    public void processGetByColorRequest(){
        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        List<Vehicle> vehicleList = dealership.getVehiclesByColor(color);
        displayVehicles(vehicleList);
    }
    public void processGetByMileageRequest(){
        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicleList = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicleList);
    }
    public void processGetByVehicleTypeRequest(){
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine().trim();

        List<Vehicle> vehicleList = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicleList);
    }
    public void processGetAllVehiclesRequest(){
         processAllVehiclesRequest();
    }
    public void processAddVehicleRequest(){
        System.out.print("Enter the vin: ");
        int vin = scanner.nextInt();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the make: ");
        String make = scanner.nextLine().trim();
        System.out.print("Enter the model: ");
        String model = scanner.nextLine().trim();
        System.out.print("Enter the vehicle type: ");
        String vehicleType = scanner.nextLine().trim();
        System.out.print("Enter the color: ");
        String color = scanner.nextLine().trim();
        System.out.print("Enter the mileage: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();

        dealership.addVehicle(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Your vehicle has been successfully added.");
    }
    public void processRemoveVehicleRequest(){
        System.out.print("Enter the vin of the vehicle you want to remove: ");
        int vin = scanner.nextInt();

        dealership.removeVehicle(new Vehicle(vin,0,"","","","",0,0));
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Your vehicle has been successfully removed.");
    }

    // Helper methods
    private void displayVehicles(List<Vehicle> vehicleList){
        System.out.printf("%-7s|%-6s|%-8s|%-10s|%-15s|%-9s|%-10s|%-10s\n",
                "VIN","Year","Make","Model","Vehicle Type","Color","Odometer","Price");
        System.out.println("--------------------------------------------------------------------------------");

        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle);
        }
        System.out.println();
    }

    public void processAllVehiclesRequest(){
        // get all vehicles
        List<Vehicle> vehicleList = dealership.getAllVehicles();
        // call method to display the vehicles
        displayVehicles(vehicleList);
    }


}
