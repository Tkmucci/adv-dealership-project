package com.yearup.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    //my variables declared here at the top of the class, so I can reuse them throughout the class
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    //my constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    //my getters and setters
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

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    //my get vehicles by price method
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //my get vehicles by make and model method
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {

        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getMake().equalsIgnoreCase(make) &&

                    vehicle.getModel().equalsIgnoreCase(model)) {

                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //my get vehicles by year method
    public List<Vehicle> getVehiclesByYear(int min, int max) {

        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {

                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //my get vehicles by color method
    public List<Vehicle> getVehiclesByColor(String color) {

        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getColor().equalsIgnoreCase(color)) {

                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //my get vehicles by mileage method
    public List<Vehicle> getVehiclesByMileage(int min, int max) {

        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {

                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //my get vehicles by type method
    public List<Vehicle> getVehiclesByType(String vehicleType) {

        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {

                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
}