package com.yearup.dealership;

public abstract class Contract {

    protected String dateOfContract;
    protected String customerName;
    protected String customerEmail;
    Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle){

        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicle;

    }

    public abstract double getMonthlyPayment();
    public abstract double getTotalPrice();
    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}
