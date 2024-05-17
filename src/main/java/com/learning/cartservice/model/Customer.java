package com.learning.cartservice.model;

public class Customer {
    private String customerEmail;
    private String customerName;
    private boolean isPremium;

    public Customer() {
    }

    public Customer(String customerEmail, String customerName, boolean isPremium) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.isPremium = isPremium;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerEmail='" + customerEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                ", isPremium=" + isPremium +
                '}';
    }
}
