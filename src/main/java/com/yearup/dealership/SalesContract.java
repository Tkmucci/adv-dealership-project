package com.yearup.dealership;

public class SalesContract extends Contract {

    private double salesTaxAmount = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {

        super(dateOfContract, customerName, customerEmail, vehicleSold);
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
