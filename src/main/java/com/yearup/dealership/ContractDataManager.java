package com.yearup.dealership;

import java.io.*;

public class ContractDataManager {

    public Dealership getContracts() {
        System.out.println("loading contracts...");
        String readFileName = "contracts.csv";
        Dealership dealership = null;

        try {

            String line;
            int lineNumber = 0;

            BufferedReader bufReader = new BufferedReader(
                    new FileReader("src/main/resources/" + readFileName));

            while ((line = bufReader.readLine()) != null) {

                String[] dParts = line.split("\\|");
                lineNumber++;

                // Process first line - dealership info
                if (lineNumber == 1) {

                    if (dParts.length == 3) {

                        String name = dParts[0];
                        String address = dParts[1];
                        String phone = dParts[2];
                        dealership = new Dealership(name, address, phone);

                    } else {
                        System.out.println("Invalid dealership header format.");
                        break;
                    }
                    continue;
                }

                // Process vehicle lines
                if (dParts.length == 4) {

                    LeaseContract leaseContract = createLeaseContract(dParts);
                    dealership.addContract(leaseContract);

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

    public void saveContract(Dealership dealership) {
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

            // Write all contracts
            for (Contract contract : dealership.getContracts()) {

                bufWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        contract.getDateOfContract(),
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        contract.getTotalPrice(),
                        contract.getMonthlyPayment(),
                        contract.getVehicleSold().getVin()
                ));
            }

            System.out.println("Inventory saved successfully.");

        } catch (
                IOException e) {
            System.out.println("Error saving contract. Please check the file and try again.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
    private LeaseContract createLeaseContract(String[] dataParts) {


        String dateOfContract = dataParts[0];
        String customerName = dataParts[1];
        String customerEmail = dataParts[2];
        String vehicleSold = dataParts[3];


        return new LeaseContract(dateOfContract, customerName, customerEmail,vehicleSold);
    }

}
