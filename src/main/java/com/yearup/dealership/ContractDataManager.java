package com.yearup.dealership;

import java.io.*;

public class ContractDataManager {

    public void saveContract(Contract contract) {
        
        
        try (
                
                BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/contracts.csv", true))) {

            if (contract instanceof SalesContract) {

                String line = getLine((SalesContract) contract);

                writer.write(line);
                writer.newLine();

            } else if (contract instanceof LeaseContract) {
                String line = getLine((LeaseContract) contract);

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Contract saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }

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
                sale.isFinanced() ? "YES" : "NO",
                sale.getMonthlyPayment()
        );

        return line;
    }
}