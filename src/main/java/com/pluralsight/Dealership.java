/*
Dealership will hold information about the dealership (name, address, ...) and maintain a
 list of vehicles. Since it has the list of vehicles, it will also have the methods that
 search the list for matching vehicles as well as add/remove vehicles.
 */

package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    // Data fields
    private String name;
    private String address;
    private String phone;
    ArrayList<Vehicle> inventory;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    // Getters and Setters for data fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Methods
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> vehiclesByPrice = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                vehiclesByPrice.add(vehicle);
            }
        }
        return vehiclesByPrice;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                vehiclesByMakeModel.add(vehicle);
            }
        }
        return vehiclesByMakeModel;
    }

    public List<Vehicle> getVehiclesByYear(double min, double max){
        List<Vehicle> vehiclesByYear = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getYear() >= min && vehicle.getYear() <= max){
                vehiclesByYear.add(vehicle);
            }
        }
        return vehiclesByYear;
    }

    public List<Vehicle> getVehiclesByColor(String color){

        List<Vehicle> vehiclesColorList = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                vehiclesColorList.add(vehicle);
            }
        }
        return vehiclesColorList;
    }

    public  List<Vehicle> getVehiclesByMileage(double min,double max){
        List<Vehicle> vehicleByMileage = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                vehicleByMileage.add(vehicle);
            }
        }
        return  vehicleByMileage;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> vehicleByType = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicleByType.add(vehicle);
            }
        }
        return vehicleByType;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    // To add vehicles to the dealership
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }

    // To remove vehicles from the dealership
    public void removeVehicle(Vehicle vehicle){

        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getVin() == vehicle.getVin()) {
                inventory.remove(inventory.get(i));
            }
        }
    }
}