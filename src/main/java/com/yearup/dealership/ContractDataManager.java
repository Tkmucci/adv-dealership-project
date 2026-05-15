package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    DealershipFileManager fileManager;
    Dealership dealership;

    public void saveInventory(Contract contract ) {
        System.out.println("Saving inventory...");
        String readFileName = "contracts.csv";

        try (
                BufferedWriter bufWriter = new BufferedWriter(
                        new FileWriter("src/main/resources/" + readFileName))) {

            // Write dealership info
            bufWriter.write(String.format("%s|%s|%s%n",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone()));

//            // Write all vehicles
//            for (Vehicle vehicle : contract.getContracts()) {
//
//                bufWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
//                        contract.getDateOfContract(),
//                        contract.getCustomerName(),
//                        contract.getCustomerEmail(),
//                        contract.getTotalPrice(),
//                        contract.getMonthlyPayment(),
//                        contract.getVehicleSold().getVin()
//                ));
//            }

            System.out.println("Inventory saved successfully.");

        } catch (
                IOException e) {
            System.out.println("Error saving inventory. Please check the file and try again.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

}
