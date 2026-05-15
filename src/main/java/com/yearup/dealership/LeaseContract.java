package com.yearup.dealership;

public class LeaseContract extends Contract{

    protected double expectedEndingValue;
    protected  double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold){

        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        return getTotalPrice() + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return (totalPrice * 0.04) + getMonthlyPayment();
    }

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
