package com.yearup.dealership;

public abstract class Contract {

    //my protected variables
    protected String dateOfContract;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    //my constructor
    public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle){

        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicle;
        this.totalPrice = getTotalPrice();
        this.monthlyPayment = getMonthlyPayment();

    }

    //my abstract methods
    public abstract double getMonthlyPayment();
    public abstract double getTotalPrice();

    //my getters and setters
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
