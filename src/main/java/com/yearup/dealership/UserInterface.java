package com.yearup.dealership;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Contract contract;
    private final Scanner userInput;

    public UserInterface() {
        this.userInput = new Scanner(System.in);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        ContractDataManager contractDataManager = new ContractDataManager();
        //this.contract = contractDataManager.getContracts();
        this.dealership = fileManager.getDealership();
    }

    //my Display method.
    //I will use it to display the menu and get user input
    public void display() {
        init();

        System.out.println("\n====================================");
        System.out.println("Welcome to " + dealership.getName());
        System.out.println("====================================");

        //my do while loop that will keep looping until the user enters 99.
        do {

            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - View Contracts");
            System.out.println("99 - Quit");
            System.out.print("\nEnter your choice: ");

            //my user input.
            String choice = userInput.nextLine();

            //my switch statement.
            switch (choice) {

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
                case "10":
                    processContracts();
                    break;
                case "b", "B":
                    break;
                case "99":

                    // Save to file
                    DealershipFileManager fileManager = new DealershipFileManager();
                    fileManager.saveDealership(dealership);

                    System.out.println("\nThank you for visiting " + dealership.getName() + "!");

                    System.exit(0);


                default:
                    System.out.println("\nInvalid choice. Please try again.");

            }

            System.out.println("Press ENTER to continue back to Main Menu...");
            userInput.nextLine();
        }while (true);

    }

    //my display vehicles method. Which I will use to display the vehicles in a formatted manner.
    private void displayVehicles(List<Vehicle> vehicles) {

        if (vehicles.isEmpty()) {

            System.out.println("\nNo vehicles found matching your criteria.");
            return;
        }

        System.out.println("\n" + "=".repeat(100));
        System.out.printf("%-10s %-6s %-15s %-15s %-12s %-12s %-12s %-10s%n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("=".repeat(100));

        for (Vehicle vehicle : vehicles) {

            System.out.printf("%-10d %-6d %-15s %-15s %-12s %-12s %-12d $%-9.2f%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());
        }
        System.out.println("=".repeat(100));
        System.out.println("Total vehicles found: " + vehicles.size());
    }

    //my process get by price request.
    public void processGetByPriceRequest() {

        System.out.print("\nEnter minimum price: ");
        double min = userInput.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = userInput.nextDouble();
        userInput.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    //my process get by make model request.
    public void processGetByMakeModelRequest() {

        System.out.print("\nEnter make: ");
        String make = userInput.nextLine();
        System.out.print("Enter model: ");
        String model = userInput.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {

        System.out.print("\nEnter minimum year: ");
        int min = userInput.nextInt();
        System.out.print("Enter maximum year: ");
        int max = userInput.nextInt();
        userInput.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {

        System.out.print("\nEnter color: ");
        String color = userInput.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {

        System.out.print("\nEnter minimum mileage: ");
        int min = userInput.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = userInput.nextInt();
        userInput.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {

        System.out.print("\nEnter vehicle type (car, truck, SUV, van): ");
        String type = userInput.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {

        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {

        System.out.println("\n--- Add New Vehicle ---");

        System.out.print("Enter VIN: ");
        int vin = userInput.nextInt();

        System.out.print("Enter year: ");
        int year = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Enter make: ");
        String make = userInput.nextLine();

        System.out.print("Enter model: ");
        String model = userInput.nextLine();

        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String vehicleType = userInput.nextLine();

        System.out.print("Enter color: ");
        String color = userInput.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometer = userInput.nextInt();

        System.out.print("Enter price: ");
        double price = userInput.nextDouble();
        userInput.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);

        // Save to file
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("\nVehicle added successfully!");
    }

    public void processRemoveVehicleRequest() {

        System.out.print("\nEnter VIN of vehicle to remove: ");
        int vin = userInput.nextInt();
        userInput.nextLine();

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == vin) {

                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {

            dealership.removeVehicle(vehicleToRemove);

            // Save to file
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);

            System.out.println("\nVehicle removed successfully!");
        } else {
            System.out.println("\nVehicle with VIN " + vin + " not found.");
        }
    }

    public void processContracts() {

        System.out.println("\n--- Contracts ---");
        System.out.println("Contracts features coming soon!");
    }
}