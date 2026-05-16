package com.yearup.dealership;

import java.io.*;

public class DealershipFileManager {

    //my method to load the contracts from a file
    public Dealership getDealership() {

        System.out.println("Inventory loading...");
        String readFileName = "inventory.csv";
        Dealership dealership = null;

        try {

            String line;
            int lineNumber = 0;

            BufferedReader bufReader = new BufferedReader(
                    new FileReader("src/main/resources/" + readFileName));

            while ((line = bufReader.readLine()) != null) {

                String[] dataParts = line.split("\\|");
                lineNumber++;

                // Process first line - dealership info
                if (lineNumber == 1) {

                    if (dataParts.length == 3) {

                        String name = dataParts[0];
                        String address = dataParts[1];
                        String phone = dataParts[2];
                        dealership = new Dealership(name, address, phone);

                    } else {
                        System.out.println("Invalid dealership header format.");
                        break;
                    }
                    continue;
                }

                // Process vehicle lines
                if (dataParts.length == 8) {

                    Vehicle vehicle = createVehicle(dataParts);
                    dealership.addVehicle(vehicle);

                } else {

                    System.out.println("Unformatted data on line " + lineNumber + " - data cannot be loaded.");
                }
            }

            bufReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file name and try again.");
        } catch (IOException e) {
            System.out.println("Error reading file. Please check the file and try again.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file. Please check the file and try again.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return dealership;
    }

    //my method to save the inventory to a file
    public void saveDealership(Dealership dealership) {

        System.out.println("Saving inventory...");
        String readFileName = "inventory.csv";

        try (BufferedWriter bufWriter = new BufferedWriter(
                new FileWriter("src/main/resources/" + readFileName))) {

            // Write dealership info
            bufWriter.write(String.format("%s|%s|%s%n",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone()));

            // Write all vehicles
            for (Vehicle vehicle : dealership.getInventory()) {

                bufWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()));
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory. Please check the file and try again.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    //my method to create a vehicle from a line of data
    private Vehicle createVehicle(String[] dataParts) {

        int vin = Integer.parseInt(dataParts[0]);
        int year = Integer.parseInt(dataParts[1]);
        String make = dataParts[2];
        String model = dataParts[3];
        String vehicleType = dataParts[4];
        String color = dataParts[5];
        int odometer = Integer.parseInt(dataParts[6]);
        double price = Double.parseDouble(dataParts[7]);

        return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
    }
}