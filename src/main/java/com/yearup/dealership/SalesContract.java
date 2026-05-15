package com.yearup.dealership;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private double recordingFee = 100;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {

        super(dateOfContract, customerName, customerEmail, vehicleSold);

        // Calculate the actual dollar amounts
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05;
        this.recordingFee = 100.00;

        // Processing fee based on vehicle price
        if (vehicleSold.getPrice() < 10000) {
            this.processingFee = 295.00;
        } else {
            this.processingFee = 495.00;
        }

        this.isFinanced = isFinanced;
    }

    @Override
    public double getTotalPrice(){

        return getTotalPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment(){

        isFinanced = true;

        if (totalPrice >= 10000){

            return getTotalPrice() * 0.0425;
        }
        if (totalPrice < 10000){

            return getTotalPrice() * 0.0525;
        }

        if (!isFinanced){

            return 0;
        }
        return getTotalPrice();
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}
