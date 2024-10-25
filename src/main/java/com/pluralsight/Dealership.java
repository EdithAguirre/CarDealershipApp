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
    static ArrayList<Vehicle> inventory;

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
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){

        return null;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }

    public List<Vehicle> getVehiclesByYear(double min, double max){
        return null;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        return null;
    }

    public  List<Vehicle> getVehiclesByMileage(double min,double max){
        return  null;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        return null;
    }

    // To add vehicles to the dealership
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    // To remove vehicles from the dealership
    public void removeVehicle(Vehicle vehicle){

    }
}
