package com.yearup.dealership;

public class LeaseContract extends Contract{

    //my protected variables
    protected double expectedEndingValue;
    protected  double leaseFee;

    //my constructor
    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold){

        super(dateOfContract, customerName, customerEmail, vehicleSold);

        this.expectedEndingValue = vehicleSold.getPrice() * 0.5;
        this.leaseFee = vehicleSold.getPrice() * 0.07;

    }

    //my overridden methods
    @Override
    public double getTotalPrice() {
        return expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {

        double principal = getTotalPrice();
        double annualRate = 0.04;
        int months = 36;

        double monthlyRate = annualRate / 12;
        double top = monthlyRate * Math.pow(1 + monthlyRate, months);
        double bottom = Math.pow(1 + monthlyRate, months) - 1;
        return ((principal * top) / bottom)  ;
    }

    //my getters and setters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}
