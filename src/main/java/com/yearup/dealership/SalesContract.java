package com.yearup.dealership;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private double recordingFee;
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

        if (!isFinanced) {
            return 0;
        }

        double principal = getTotalPrice();
        double annualRate;
        int months;

        if (vehicleSold.getPrice() >= 10000) {
            annualRate = 0.0425;
            months = 48;
        } else {
            annualRate = 0.0525;
            months = 24;
        }

        double monthlyRate = annualRate / 12;
        double top = monthlyRate * Math.pow(1 + monthlyRate, months);
        double bottom = Math.pow(1 + monthlyRate, months) - 1;
        return ((principal * top) / bottom)  ;

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
