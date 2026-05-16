package com.yearup.dealership;

import java.io.*;

public class ContractDataManager {

    //my method to save the contract to a file
    public void saveContract(Contract contract) {
        
        //my try-with-resources statement to automatically close the file
        try (

                //my BufferedWriter to write the contract to a file
                BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/contracts.csv", true))) {

            //my if-else statement to determine the type of contract and format the line accordingly
            // using instanceof
            if (contract instanceof SalesContract) {

                String line = getLine((SalesContract) contract);

                writer.write(line);
                writer.newLine();

            } else if (contract instanceof LeaseContract) {
                String line = getLine((LeaseContract) contract);

                writer.write(line);
                writer.newLine();
            }

            //my print statement to confirm the contract was saved successfully
            System.out.println("Contract saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }

    //my method to format the Lease contract line if it is a LeaseContract
    private static String getLine(LeaseContract contract) {

        LeaseContract lease = contract;
        Vehicle vehicle = lease.getVehicleSold();

        String line = String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f",
                lease.getDateOfContract(),
                lease.getCustomerName(),
                lease.getCustomerEmail(),
                vehicle.getVin(),
                vehicle.getYear(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getVehicleType(),
                vehicle.getColor(),
                vehicle.getOdometer(),
                vehicle.getPrice(),
                lease.getExpectedEndingValue(),
                lease.getLeaseFee(),
                lease.getTotalPrice(),
                lease.getMonthlyPayment()
        );
        return line;
    }

    //my method to format the Sales contract line if it is a SalesContract
    private static String getLine(SalesContract contract) {

        SalesContract sale = contract;

        Vehicle vehicle = sale.getVehicleSold();

        String line = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                sale.getDateOfContract(),
                sale.getCustomerName(),
                sale.getCustomerEmail(),
                vehicle.getVin(),
                vehicle.getYear(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getVehicleType(),
                vehicle.getColor(),
                vehicle.getOdometer(),
                vehicle.getPrice(),
                sale.getSalesTaxAmount(),
                sale.getRecordingFee(),
                sale.getProcessingFee(),
                sale.getTotalPrice(),

//Don't mind this I was just trying to remind myself what this is
// doing because it opted to use the ternary operator
//        if (sale.isFinanced()) {
//            return "YES";
//        } else {
//            return "NO";
//        }
                sale.isFinanced() ? "YES" : "NO",
                sale.getMonthlyPayment()
        );

        return line;
    }
}